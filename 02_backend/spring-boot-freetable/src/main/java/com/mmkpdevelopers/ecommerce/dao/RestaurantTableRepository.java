package com.mmkpdevelopers.ecommerce.dao;

import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
@Repository
@CrossOrigin("http://localhost:4200")
public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    RestaurantTable getRestaurantTableById(Long id);
}
