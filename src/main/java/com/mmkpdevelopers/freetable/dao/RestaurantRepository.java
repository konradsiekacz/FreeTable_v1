package com.mmkpdevelopers.freetable.dao;

import com.mmkpdevelopers.freetable.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
