package com.mmkpdevelopers.ecommerce.converter;

import com.mmkpdevelopers.ecommerce.dto.ReservationItemDTO;
import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReservationItemConverter {

    public static ReservationItemDTO entityToDto(ReservationItem reservationItem){
        ReservationItemDTO reservationItemDTO = new ReservationItemDTO();
        reservationItemDTO.setReservationItemId(reservationItem.getReservationItemId());
        reservationItemDTO.setRestaurantName(reservationItem.getRestaurantName());
        reservationItemDTO.setTable_id(reservationItem.getTable_id());
        reservationItemDTO.setId(reservationItem.getId());
        reservationItemDTO.setNumberInRestaurant(reservationItem.getNumberInRestaurant());
        reservationItemDTO.setNumberOfSeats(reservationItem.getNumberOfSeats());
        return reservationItemDTO;
    }

    public static List<ReservationItemDTO> enititesToDto(List<ReservationItem> reservationItemList){
        return reservationItemList.stream()
                .map(ReservationItemConverter::entityToDto)
                .collect(Collectors.toList());
    }

    public static ReservationItem dtoToEntity (ReservationItemDTO reservationItemDTO){
        ReservationItem reservationItem = new ReservationItem();
        reservationItem.setReservationItemId(reservationItemDTO.getReservationItemId());
        reservationItem.setRestaurantName(reservationItemDTO.getRestaurantName());
        reservationItem.setTable_id(reservationItemDTO.getTable_id());
        reservationItem.setId(reservationItemDTO.getId());
        reservationItem.setNumberInRestaurant(reservationItemDTO.getNumberInRestaurant());
        reservationItem.setNumberOfSeats(reservationItemDTO.getNumberOfSeats());
        return reservationItem;
    }
}
