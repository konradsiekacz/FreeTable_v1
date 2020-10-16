package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.ReservationItemRepository;
import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservationItemService {

    private ReservationItemRepository reservationItemRepository;

    public ReservationItemService(ReservationItemRepository reservationItemRepository) {
        this.reservationItemRepository = reservationItemRepository;
    }

//    public ReservationItem getReservationItemByReservationItemId(Long reservationItemId) {
//        return reservationItemRepository.getReservationItemByReservationItemId();
//    }

    public List<ReservationItem> findReservationItemById(Long id){
        return reservationItemRepository.findReservationItemsById(id);
    }

    public List<ReservationItem> getAllReservationItems() {
        return reservationItemRepository.findAll();
    }

    public List<ReservationItem> findReservationRestaurantId(Long id){
        return reservationItemRepository.findAllByRestaurantId(id);
    }

    public void saveReservationItem(ReservationItem reservationItem) {
        reservationItemRepository.save(reservationItem);
    }

    public void deleteReservationItem(Long id) {
        reservationItemRepository.deleteById(id);
    }
}
