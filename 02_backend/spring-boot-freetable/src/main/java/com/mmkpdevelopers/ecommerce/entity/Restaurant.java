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
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "imageurl")
    private String imageUrl;

    @Column(name = "average_price_for_meal")
    private long averagePriceForMeal;

    @OneToMany(mappedBy = "restaurant", cascade=CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id")
    private List<RestaurantTable> restaurantTables = new ArrayList<RestaurantTable>();



    public Restaurant(){

    }

    public Restaurant(long id, String name, String address, String imageUrl, long averagePriceForMeal) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.imageUrl = imageUrl;
        this.averagePriceForMeal = averagePriceForMeal;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @OneToMany
    @JoinColumn(name="id")
    public List<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }


    public void setRestaurantTables(List<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", averagePriceForMeal=" + averagePriceForMeal +
                '}';
    }
}
