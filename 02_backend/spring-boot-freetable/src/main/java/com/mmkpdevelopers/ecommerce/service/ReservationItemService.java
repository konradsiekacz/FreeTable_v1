package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.ReservationItemRepository;
import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationItemService {

    private ReservationItemRepository reservationItemRepository;

    public ReservationItemService(ReservationItemRepository reservationItemRepository) {
        this.reservationItemRepository = reservationItemRepository;
    }

    public ReservationItem getReservationItemById(Long id) {
        return reservationItemRepository.getReservationItemById(id);
    }

    public List<ReservationItem> getAllReservationItems() {
        return reservationItemRepository.findAll();
    }

    public void addReservationItem(ReservationItem reservationItem) {
        reservationItemRepository.save(reservationItem);
    }

    public void updateReservationItem(ReservationItem updateReservationItem) {
        ReservationItem existingReservationItem = getReservationItemById(updateReservationItem.getId());
        existingReservationItem.setReservationItemId(updateReservationItem.getReservationItemId());
        existingReservationItem.setRestaurantName(updateReservationItem.getRestaurantName());
        existingReservationItem.setTable_id(updateReservationItem.getTable_id());
        existingReservationItem.setNumberInRestaurant(updateReservationItem.getNumberInRestaurant());
        existingReservationItem.setNumberOfSeats(updateReservationItem.getNumberOfSeats());
        reservationItemRepository.save(existingReservationItem);
    }

    public void deleteReservationItem(Long id) {
        reservationItemRepository.deleteReservationItemById(id);
    }
}
