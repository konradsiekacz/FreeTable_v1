package com.mmkpdevelopers.ecommerce.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class RestaurantTableDto {

    private long tableId;
    private long id;
    private long numberInRestaurant;
    private long numberOfSeats;

    public RestaurantTableDto() {
    }

    public RestaurantTableDto(long id, long tableId, long numberInRestaurant, long numberOfSeats) {
        this.id = id;
        this.tableId = tableId;
        this.numberInRestaurant = numberInRestaurant;
        this.numberOfSeats = numberOfSeats;
    }
}
