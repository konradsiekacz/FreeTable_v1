package com.mmkpdevelopers.ecommerce.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RestaurantTableNotFoundExceptions extends RuntimeException {

    public RestaurantTableNotFoundExceptions(Long id){
        super(String.format("Table not found with given id: %s", id));
    }
}
