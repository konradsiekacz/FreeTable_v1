package com.mmkpdevelopers.ecommerce.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name="reservation_item")
@Data
public class ReservationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_item_id")
    private long reservationItemId;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "id")
    private long id;

    @Column(name = "table_id")
    private long table_id;

    @Column(name = "number_in_restaurant")
    private long numberInRestaurant;

    @Column(name = "number_of_seats")
    private long numberOfSeats;

    public ReservationItem() {
    }

    public ReservationItem(long reservationItemId, String restaurantName, long id, long table_id, long numberInRestaurant, long numberOfSeats) {
        this.reservationItemId = reservationItemId;
        this.restaurantName = restaurantName;
        this.id = id;
        this.table_id = table_id;
        this.numberInRestaurant = numberInRestaurant;
        this.numberOfSeats = numberOfSeats;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_item_id")
    public long getReservationItemId() {
        return reservationItemId;
    }

    public void setReservationItemId(long reservationItemId) {
        this.reservationItemId = reservationItemId;
    }

    @Column(name = "restaurant_name")
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "table_id")
    public long getTable_id() {
        return table_id;
    }

    public void setTable_id(long table_id) {
        this.table_id = table_id;
    }

    @Column(name = "number_in_restaurant")
    public long getNumberInRestaurant() {
        return numberInRestaurant;
    }

    public void setNumberInRestaurant(long numberInRestaurant) {
        this.numberInRestaurant = numberInRestaurant;
    }

    @Column(name = "number_of_seats")
    public long getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(long numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }
}
