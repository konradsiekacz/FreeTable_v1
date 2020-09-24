package com.mmkpdevelopers.ecommerce.config;

import com.mmkpdevelopers.ecommerce.converter.CustomerConverter;
import com.mmkpdevelopers.ecommerce.dto.CustomerDto;
import com.mmkpdevelopers.ecommerce.entity.Customer;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import com.mmkpdevelopers.ecommerce.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

    private CustomerService customerService;
    private CustomerConverter customerConverter;

    public CustomerController(CustomerService customerService, CustomerConverter customerConverter) {
        this.customerService = customerService;
        this.customerConverter = customerConverter;
    }
    @GetMapping(value = "/customers", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<CustomerDto> getAllCustomer(){
        return customerConverter.entitiesToDto(customerService.getCustomers());
    }

    @GetMapping(value = "customer/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CustomerDto getCustomerById(@PathVariable Long id) throws ResourceNotFoundException {
        return customerConverter.entityToDto(customerService.getCustomerById(id));
    }

}
