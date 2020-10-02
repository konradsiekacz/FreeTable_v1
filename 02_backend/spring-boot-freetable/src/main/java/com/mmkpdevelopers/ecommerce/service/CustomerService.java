package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.CustomerRepository;
import com.mmkpdevelopers.ecommerce.entity.Customer;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCustomers () {
        return customerRepository.findAll().stream()
                .map(customer -> new Customer(customer.getId(), customer.getName(),
                        customer.getSurname(),
                        customer.getEmail(), customer.getPhoneNumber(), customer.getImageUrl()))
                .collect(Collectors.toList());
    }
    public Customer getCustomerById (Long id) throws ResourceNotFoundException {
        return customerRepository.findAll().stream()
                .filter(customer -> customer.getId()==id)
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException("Customer with provided ID is not found"));
    }
    public Customer addCustomer (Customer customer) {
        return customerRepository.save(customer);
    }
    public void updateCustomer (Customer customer) {
        customerRepository.save(customer);
    }
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
            throws org.springframework.data.rest.webmvc.ResourceNotFoundException {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("Customer not found for this id :: " + customerId));

        customerRepository.delete(customer);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
