package com.mmkpdevelopers.ecommerce.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RestaurantTableDto {

    private long tableId;
    private long id;
    private long numberInRestaurant;
    private long numberOfSeats;

    public RestaurantTableDto() {
    }

    public RestaurantTableDto(long id, long tableId,long numberInRestaurant, long numberOfSeats) {
        this.id = id;
        this.tableId = tableId;
        this.numberInRestaurant = numberInRestaurant;
        this.numberOfSeats = numberOfSeats;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public long getNumberInRestaurant() {
        return numberInRestaurant;
    }

    public void setNumberInRestaurant(long numberInRestaurant) {
        this.numberInRestaurant = numberInRestaurant;
    }
}
