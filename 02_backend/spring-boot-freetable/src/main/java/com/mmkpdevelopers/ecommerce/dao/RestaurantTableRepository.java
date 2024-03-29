package com.mmkpdevelopers.ecommerce.dao;

import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    RestaurantTable deleteRestaurantTableById(Long id);
}
