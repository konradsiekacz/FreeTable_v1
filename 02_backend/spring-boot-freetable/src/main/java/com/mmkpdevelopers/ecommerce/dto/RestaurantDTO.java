package com.mmkpdevelopers.ecommerce.dto;

import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;

import java.util.ArrayList;
import java.util.List;

public class RestaurantDTO {

    private long id;
    private String name;
    private String address;
    private String imageUrl;
    private long averagePriceForMeal;
    private List<RestaurantTable> restaurantTables = new ArrayList<RestaurantTable>();

    public static final class Builder {

        private long id;
        private String name;
        private String address;
        private String imageUrl;
        private long averagePriceForMeal;
        private List<RestaurantTable> restaurantTables;

        public RestaurantDTO.Builder id(long id) {
            this.id = id;
            return this;
        }

        public RestaurantDTO.Builder name(String name) {
            this.name = name;
            return this;
        }

        public RestaurantDTO.Builder address(String address) {
            this.address = address;
            return this;
        }

        public RestaurantDTO.Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public RestaurantDTO.Builder averagePriceForMeal(long averagePriceForMeal) {
            this.averagePriceForMeal = averagePriceForMeal;
            return this;
        }

        public RestaurantDTO.Builder restaurantTables(List<RestaurantTable> restaurantTables) {
            this.restaurantTables = restaurantTables;
            return this;
        }

        public RestaurantDTO build() {
            RestaurantDTO restaurantDTO = new RestaurantDTO();
            restaurantDTO.id = this.id;
            restaurantDTO.name = this.name;
            restaurantDTO.address = this.address;
            restaurantDTO.averagePriceForMeal = this.averagePriceForMeal;
            restaurantDTO.imageUrl = this.imageUrl;
            restaurantDTO.restaurantTables = this.restaurantTables;
            return restaurantDTO;
        }

    }

}
