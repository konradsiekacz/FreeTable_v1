package com.mmkpdevelopers.ecommerce.dao;

import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface ReservationItemRepository extends JpaRepository<ReservationItem, Long> {
    ReservationItem getReservationItemById(Long id);
    ReservationItem deleteReservationItemById(long id);
}
