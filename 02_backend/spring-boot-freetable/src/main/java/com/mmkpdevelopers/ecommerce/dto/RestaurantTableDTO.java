package com.mmkpdevelopers.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestaurantTableDTO {

    private long tableId;
    private long id;
    private long numberInRestaurant;
    private long numberOfSeats;

    public static final class Builder {

        private long tableId;
        private long id;
        private long numberInRestaurant;
        private long numberOfSeats;


        public RestaurantTableDTO.Builder tableId(long id) {
            this.tableId = tableId;
            return this;
        }

        public RestaurantTableDTO.Builder id(long id) {
            this.id = id;
            return this;
        }

        public RestaurantTableDTO.Builder numberInRestaurant(long numberInRestaurant) {
            this.numberInRestaurant = numberInRestaurant;
            return this;
        }

        public RestaurantTableDTO.Builder surname(long numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            return this;
        }


        public RestaurantTableDTO build() {
            RestaurantTableDTO restaurantTableDTO = new RestaurantTableDTO();
            restaurantTableDTO.tableId = this.tableId;
            restaurantTableDTO.id = this.id;
            restaurantTableDTO.numberInRestaurant = this.numberInRestaurant;
            restaurantTableDTO.numberOfSeats = this.numberOfSeats;
            return restaurantTableDTO;
        }
    }
}
