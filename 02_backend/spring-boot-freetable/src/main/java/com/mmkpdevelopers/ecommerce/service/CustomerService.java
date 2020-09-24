package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.CustomerRepository;
import com.mmkpdevelopers.ecommerce.entity.Customer;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    public List<Customer> getCustomers () {
        return customerRepository.findAll();
//                .map(customer -> new Customer(customer.getId(), customer.getName(),
//                        customer.getSurname(),
//                        customer.getEmail(), customer.getPhoneNumber(), customer.getImageUrl()))
//                .collect(Collectors.toList());
    }
    public Customer getCustomerById (Long id) throws ResourceNotFoundException {
        return customerRepository.findAll().stream()
                .filter(customer -> customer.getId()==id)
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException("Customer with provided ID is not found"));
    }
    public void addCustomer (Customer customer) {
        customerRepository.save(customer);
    }
    public void updateCustomer (Customer customer) {
        customerRepository.save(customer);
    }
    public void deleteCustomer (Customer customer) {
        customerRepository.delete(customer);
    }
}
