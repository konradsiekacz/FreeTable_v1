package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.RestaurantTableRepository;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestaurantTableService {

    private RestaurantTableRepository restaurantTableRepository;
    private ResourceNotFoundException ResourceNotFoundException;

    public RestaurantTableService(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    public List<RestaurantTable> getAllRestaurantTables(){
        return restaurantTableRepository.findAll().stream()
                .map(table -> new RestaurantTable(table.getId(), table.getTableId(), table.getNumberInRestaurant(), table.getNumberOfSeats()))
                .collect(Collectors.toList());
    }

    public RestaurantTable getRestaurantTable(Long id) throws ResourceNotFoundException {
        return restaurantTableRepository.findAll().stream()
                .filter(table -> table.getId()==id)
                .findAny()
                .orElseThrow(()-> new ResourceNotFoundException("Table not found with given id"));
    }

    public RestaurantTable addRestaurantTable(RestaurantTable restaurantTable){
       return restaurantTableRepository.save(restaurantTable);
    }
}
