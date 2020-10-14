package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.RestaurantRepository;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RestaurantService {

    private RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public Restaurant getRestaurantById(Long restaurantId) {
        return restaurantRepository.getRestaurantByRestaurantId(restaurantId);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    public void addRestaurant(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

    public void updateRestaurant(Restaurant updateRestaurant) {
        Restaurant existingRestaurant = getRestaurantById(updateRestaurant.getRestaurantId());
        existingRestaurant.setName(updateRestaurant.getName());
        existingRestaurant.setAddress(updateRestaurant.getAddress());
        existingRestaurant.setImageUrl(updateRestaurant.getImageUrl());
        existingRestaurant.setAveragePriceForMeal(updateRestaurant.getAveragePriceForMeal());
        restaurantRepository.save(existingRestaurant);
    }

    public void deleteRestaurantById(Long id) {
        restaurantRepository.deleteById(id);
    }
}
