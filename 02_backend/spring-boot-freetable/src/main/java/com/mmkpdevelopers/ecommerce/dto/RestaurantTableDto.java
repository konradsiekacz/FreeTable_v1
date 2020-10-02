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

    public RestaurantTableDto(long tableId, long id, long numberInRestaurant, long numberOfSeats) {
        this.tableId = tableId;
        this.id = id;
        this.numberInRestaurant = numberInRestaurant;
        this.numberOfSeats = numberOfSeats;
    }
}
