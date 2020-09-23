package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.RestaurantTableRepository;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantTableService {

    private RestaurantTableRepository restaurantTableRepository;

    public RestaurantTableService(RestaurantTableRepository restaurantTableRepository) {
        this.restaurantTableRepository = restaurantTableRepository;
    }

    public List<RestaurantTable> getAllRestaurantTables(){
        return restaurantTableRepository.findAll();
    }
}
