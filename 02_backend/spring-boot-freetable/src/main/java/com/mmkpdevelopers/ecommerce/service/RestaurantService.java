package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.RestaurantRepository;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;

import java.util.List;

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

    public void addRestaurant(Restaurant user) {
        restaurantRepository.save(user);
    }

    public void updateRestaurant(Restaurant updateRestaurant) {
        Restaurant existingRestaurant = getRestaurantById(updateRestaurant.getId());
        existingRestaurant.setName(updateRestaurant.getName());
        existingRestaurant.setAddress(existingRestaurant.getAddress());
        existingRestaurant.setImageUrl(updateRestaurant.getImageUrl());
        existingRestaurant.setAveragePriceForMeal(existingRestaurant.getAveragePriceForMeal());
        restaurantRepository.save(existingRestaurant);
    }

    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteRestaurantById(id);
    }
}
