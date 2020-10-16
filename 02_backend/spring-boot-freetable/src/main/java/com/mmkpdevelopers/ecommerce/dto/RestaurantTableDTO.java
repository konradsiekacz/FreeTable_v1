package com.mmkpdevelopers.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RestaurantTableDTO {
    private long tableId;
    private long restaurantId;
    private long numberInRestaurant;
    private long numberOfSeats;

    public RestaurantTableDTO() {
    }

    public RestaurantTableDTO(long tableId, long restaurantId, long numberInRestaurant, long numberOfSeats) {
        this.tableId = tableId;
        this.restaurantId = restaurantId;
        this.numberInRestaurant = numberInRestaurant;
        this.numberOfSeats = numberOfSeats;
    }

    public static final class Builder {

        private long tableId;
        private long restaurantId;
        private long numberInRestaurant;
        private long numberOfSeats;

        public RestaurantTableDTO.Builder tableId(long id) {
            this.tableId = tableId;
            return this;
        }

        public RestaurantTableDTO.Builder id(long id) {
            this.restaurantId = id;
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
            restaurantTableDTO.restaurantId = this.restaurantId;
            restaurantTableDTO.numberInRestaurant = this.numberInRestaurant;
            restaurantTableDTO.numberOfSeats = this.numberOfSeats;
            return restaurantTableDTO;
        }
    }
}
