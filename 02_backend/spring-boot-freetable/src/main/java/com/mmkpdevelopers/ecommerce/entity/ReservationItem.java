package com.mmkpdevelopers.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;

@Embeddable
@Entity
@Table(name="reservation_item")
@Data
public class ReservationItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_item_id")
    private long reservationItemId;

    @Column(name="id")
    private long id;

    @Column(name="username")
    private String username;

    @Column(name = "restaurant_name")
    private String restaurantName;

    @Column(name = "restaurant_id")
    private long restaurantId;

    @Column(name = "table_id")
    private long tableId;

    @Column(name = "number_in_restaurant")
    private long numberInRestaurant;

    @Column(name = "number_of_seats")
    private long numberOfSeats;

    public ReservationItem() {
    }

    public ReservationItem(long reservationItemId, long id, String username, String restaurantName, long restaurantId, long tableId, long numberInRestaurant, long numberOfSeats) {
        this.reservationItemId = reservationItemId;
        this.id = id;
        this.username = username;
        this.restaurantName = restaurantName;
        this.restaurantId = restaurantId;
        this.tableId = tableId;
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

    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "restaurant_name")
    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Column(name = "restaurant_id")
    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long id) {
        this.restaurantId = id;
    }

    @Column(name = "table_id")
    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
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
