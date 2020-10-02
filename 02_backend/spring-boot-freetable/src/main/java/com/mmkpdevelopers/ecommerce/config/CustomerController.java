package com.mmkpdevelopers.ecommerce.config;

import com.mmkpdevelopers.ecommerce.converter.CustomerConverter;
import com.mmkpdevelopers.ecommerce.dao.CustomerRepository;
import com.mmkpdevelopers.ecommerce.dto.CustomerDto;
import com.mmkpdevelopers.ecommerce.entity.Customer;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import com.mmkpdevelopers.ecommerce.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;
    private CustomerConverter customerConverter;
    private CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerConverter customerConverter) {
        this.customerService = customerService;
        this.customerConverter = customerConverter;
    }

    @GetMapping(value = "/customers", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomer() {
        return customerConverter.entitiesToDto(customerService.getCustomers());
    }

    @GetMapping(value = "customer/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable Long id) throws ResourceNotFoundException {
        return customerConverter.entityToDto(customerService.getCustomerById(id));
    }

    @PostMapping("/customers")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        return customerService.addCustomer(customerConverter.dtoToEntity(customerDto));
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable(value = "id") Long customerId,
                                                   @Valid @RequestBody Customer customerDetails) throws org.springframework.data.rest.webmvc.ResourceNotFoundException, ResourceNotFoundException {
        Customer customer = customerService.getCustomerById(customerId);
        customer.setId(customerDetails.getId());
        customer.setName(customerDetails.getName());
        customer.setSurname(customerDetails.getSurname());
        customer.setEmail(customerDetails.getEmail());
        customer.setPhoneNumber(customerDetails.getPhoneNumber());
        final Customer updateCustomer = customerRepository.save(customer);
        return ResponseEntity.ok(updateCustomer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable(value = "id") Long id) {
        customerService.deleteCustomer(id);
    }
}
