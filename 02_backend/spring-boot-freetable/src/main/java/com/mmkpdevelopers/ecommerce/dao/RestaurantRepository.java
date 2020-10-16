package com.mmkpdevelopers.ecommerce.dao;

import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant getRestaurantByRestaurantId(Long restaurantId);

    Restaurant getRestaurantByUserId(Long userId);

}
