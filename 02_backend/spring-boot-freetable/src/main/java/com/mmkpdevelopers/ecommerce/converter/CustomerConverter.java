package com.mmkpdevelopers.ecommerce.converter;

import com.mmkpdevelopers.ecommerce.dto.CustomerDto;
import com.mmkpdevelopers.ecommerce.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerConverter {
    public CustomerDto entityToDto (Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        customerDto.setId(customer.getId());
        customerDto.setName(customer.getName());
        customerDto.setSurname(customer.getSurname());
        customerDto.setEmail(customer.getEmail());
        customerDto.setPhoneNumber(customer.getPhoneNumber());
        customerDto.setImageUrl(customer.getImageUrl());
        return customerDto;
    }
    public List<CustomerDto> entitiesToDto(List<Customer> customerList) {
        return customerList.stream()
                .map(customer -> entityToDto(customer))
                .collect(Collectors.toList());
    }
    public Customer dtoToEntity (CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setId(customerDto.getId());
        customer.setName(customerDto.getName());
        customer.setSurname(customerDto.getSurname());
        customer.setEmail(customerDto.getEmail());
        customer.setImageUrl(customerDto.getImageUrl());
        return customer;
    }
}
