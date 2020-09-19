package com.mmkpdevelopers.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Entity
@Table(name="restaurant_table")
@Data
public class RestaurantTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id")
    private long tableId;

    @Column(name = "id")
    private long id;

    @Column(name = "number_in_restaurant")
    private long numberInRestaurant;


    @Column(name = "number_of_seats")
    private long numberOfSeats;

      public RestaurantTable() {
    }

    public RestaurantTable(long tableId, long id, long numberInRestaurant, long numberOfSeats) {
        this.tableId = tableId;
        this.id = id;
        this.numberInRestaurant = numberInRestaurant;
        this.numberOfSeats = numberOfSeats;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "table_id")
    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }

    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @Column(name = "number_of_seats", nullable = false)
    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    @Column(name = "number_in_restaurant", nullable = false)
    public long getNumberInRestaurant() {
        return numberInRestaurant;
    }

    public void setNumberInRestaurant(long numberInRestaurant) {
        this.numberInRestaurant = numberInRestaurant;
    }
}
