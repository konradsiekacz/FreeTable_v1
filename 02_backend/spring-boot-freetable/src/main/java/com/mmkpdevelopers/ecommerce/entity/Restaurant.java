package com.mmkpdevelopers.ecommerce.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="restaurant")
@Data
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private long restaurantId;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "average_price_for_meal")
    private long averagePriceForMeal;

    @Column(name = "user_id")
    private long userId;


    @OneToMany(mappedBy = "restaurant", cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "restaurant_id")
    private List<RestaurantTable> restaurantTables = new ArrayList<RestaurantTable>();


    public Restaurant(){

    }

    public Restaurant(long restaurantId, String name, String address, String imageUrl, long averagePriceForMeal, long userId) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.address = address;
        this.imageUrl = imageUrl;
        this.averagePriceForMeal = averagePriceForMeal;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    public long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(long id) {
        this.restaurantId = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address", nullable = false)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "imageurl", nullable = false)
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "average_price_for_meal", nullable = false)
    public long getAveragePriceForMeal() {
        return averagePriceForMeal;
    }

    public void setAveragePriceForMeal(long averagePriceForMeal) {
        this.averagePriceForMeal = averagePriceForMeal;
    }

    @Column(name = "user_id", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @OneToMany
    @JoinColumn(name="restaurant_id")
    public List<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }


    public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + restaurantId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", averagePriceForMeal=" + averagePriceForMeal +
                '}';
    }
}
