package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.RestaurantRepository;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.getRestaurantById(id);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Restaurant updateRestaurant) {
        Restaurant existingRestaurant = getRestaurantById(updateRestaurant.getId());
        existingRestaurant.setName(updateRestaurant.getName());
        existingRestaurant.setAddress(existingRestaurant.getAddress());
        existingRestaurant.setImageUrl(updateRestaurant.getImageUrl());
        existingRestaurant.setAveragePriceForMeal(existingRestaurant.getAveragePriceForMeal());
        restaurantRepository.save(existingRestaurant);
    }

//    public Map<String, Boolean> deleteRestaurant(Long id)
//            throws org.springframework.data.rest.webmvc.ResourceNotFoundException {
//        Restaurant restaurant = restaurantRepository.findById(id)
//                .orElseThrow(() -> new org.springframework.data.rest.webmvc.ResourceNotFoundException("Restaurant not found for this id :: " + id));
//
//        restaurantRepository.delete(restaurant);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }
}
