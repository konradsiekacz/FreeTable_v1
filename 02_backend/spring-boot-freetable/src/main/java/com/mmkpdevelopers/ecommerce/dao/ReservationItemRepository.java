package com.mmkpdevelopers.ecommerce.dao;

import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {

    @Query("FROM ReservationItem WHERE id =?1")
    List<ReservationItem> findReservationItemsById(long id);

    List<ReservationItem> findAllByRestaurantId(long id);

}
