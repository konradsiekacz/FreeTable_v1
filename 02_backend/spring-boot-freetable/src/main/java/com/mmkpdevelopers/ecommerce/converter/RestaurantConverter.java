package com.mmkpdevelopers.ecommerce.converter;

import com.mmkpdevelopers.ecommerce.dto.RestaurantDTO;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantConverter {

    public static RestaurantDTO entityToDto(Restaurant restaurant) {
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setRestaurantId(restaurant.getRestaurantId());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setAddress(restaurant.getAddress());
        restaurantDTO.setImageUrl(restaurant.getImageUrl());
        restaurantDTO.setAveragePriceForMeal(restaurant.getAveragePriceForMeal());
        restaurantDTO.setUserId(restaurant.getUserId());
        restaurantDTO.setRestaurantTables(restaurant.getRestaurantTables());
        return restaurantDTO;
    }

    public static List<RestaurantDTO> entitiesToDto(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(RestaurantConverter::entityToDto)
                .collect(Collectors.toList());
    }

    public static Restaurant dtoToEntity(RestaurantDTO restaurantDTO) {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantId(restaurantDTO.getRestaurantId());
        restaurant.setName(restaurantDTO.getName());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setImageUrl(restaurantDTO.getImageUrl());
        restaurant.setAveragePriceForMeal(restaurantDTO.getAveragePriceForMeal());
        restaurant.setUserId(restaurantDTO.getUserId());
        restaurant.setRestaurantTables(restaurantDTO.getRestaurantTables());
        return restaurant;
    }
}
