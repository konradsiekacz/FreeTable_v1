package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.RestaurantTableRepository;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RestaurantTableService {
    private RestaurantTableRepository restaurantTableRepository;

    public RestaurantTableService(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    public RestaurantTable getRestaurantTableById(Long id) throws ResourceNotFoundException {
        return restaurantTableRepository.findAll().stream()
                .filter(restaurantTable -> restaurantTable.getTableId() == id)
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException("Table not found with given id"));
    }

    public List<RestaurantTable> getAllRestaurantTables() {
        return restaurantTableRepository.findAll();
    }

    public void addRestaurantTable(RestaurantTable restaurantTable) {
        restaurantTableRepository.save(restaurantTable);
    }

    public void updateRestaurantTable(RestaurantTable updateRestaurantTable) throws ResourceNotFoundException {
        RestaurantTable existingRestaurantTable = getRestaurantTableById(updateRestaurantTable.getTableId());
        existingRestaurantTable.setId(updateRestaurantTable.getId());
        existingRestaurantTable.setNumberInRestaurant(existingRestaurantTable.getNumberInRestaurant());
        existingRestaurantTable.setNumberOfSeats(updateRestaurantTable.getNumberOfSeats());
        restaurantTableRepository.save(existingRestaurantTable);
    }

    public void deleteRestaurantTableById(Long id) {
        restaurantTableRepository.deleteById(id);
    }

}
