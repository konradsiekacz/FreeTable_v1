package com.mmkpdevelopers.ecommerce.dao;

import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin("http://localhost:4200")
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Restaurant getRestaurantById(Long id);
}
