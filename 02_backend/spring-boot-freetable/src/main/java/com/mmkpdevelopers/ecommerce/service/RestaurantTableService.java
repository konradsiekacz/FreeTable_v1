package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.RestaurantTableRepository;
import com.mmkpdevelopers.ecommerce.dto.RestaurantTableDto;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import com.mmkpdevelopers.ecommerce.exception.RestaurantTableNotFoundExceptions;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RestaurantTableService {

    private RestaurantTableRepository restaurantTableRepository;
    private ResourceNotFoundException ResourceNotFoundException;

    public RestaurantTableService(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    public List<RestaurantTable> getAllRestaurantTables() {
        return restaurantTableRepository.findAll().stream()
                .map(table -> new RestaurantTable(table.getTableId(), table.getId(), table.getNumberInRestaurant(), table.getNumberOfSeats()))
                .collect(Collectors.toList());
    }

    public RestaurantTable getRestaurantTable(Long tableId) throws ResourceNotFoundException {
        return restaurantTableRepository.findAll().stream()
                .filter(table -> table.getTableId() == tableId)
                .findAny()
                .orElseThrow(() -> new ResourceNotFoundException("Table not found with given id"));
    }

    public RestaurantTable addRestaurantTable(RestaurantTable restaurantTable) {
        return restaurantTableRepository.save(restaurantTable);
    }

    public void updateRestaurantTable(RestaurantTable restaurantTable) {
        restaurantTableRepository.save(restaurantTable);
    }
//
//    public ResponseEntity<RestaurantTable> updateRestaurant(@PathVariable(value = "id") Long restaurantTableId,
//                                                            @Valid @RequestBody RestaurantTable restaurantTableDetails) throws ResourceNotFoundException {
//        RestaurantTable restaurantTable = restaurantTableService.getRestaurantTable(restaurantTableId);
//
//        restaurantTable.setId(restaurantTableDetails.getId());
//        restaurantTable.setTableId(restaurantTableDetails.getTableId());
//        restaurantTable.setNumberInRestaurant(restaurantTableDetails.getNumberInRestaurant());
//        restaurantTable.setNumberOfSeats(restaurantTableDetails.getNumberOfSeats());
//        final RestaurantTable updateRestaurantTable = restaurantTableService.updateRestaurantTable(restaurantTable);
//        return ResponseEntity.ok(updateRestaurantTable);
//    }


    public Map<String, Boolean> deleteRestaurantTable(Long id)
            throws org.springframework.data.rest.webmvc.ResourceNotFoundException {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(id)
                .orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("Restaurant not found for this id :: " + id));

        restaurantTableRepository.delete(restaurantTable);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
