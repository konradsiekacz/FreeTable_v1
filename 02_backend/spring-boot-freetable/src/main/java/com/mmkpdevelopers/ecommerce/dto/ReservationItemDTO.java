package com.mmkpdevelopers.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservationItemDTO {

    private long reservationItemId;
    private String restaurantName;
    private long id;
    private long table_id;
    private long numberInRestaurant;
    private long numberOfSeats;

    public ReservationItemDTO() {
    }

    public ReservationItemDTO(long reservationItemId, String restaurantName, long id, long table_id, long numberInRestaurant, long numberOfSeats) {
        this.reservationItemId = reservationItemId;
        this.restaurantName = restaurantName;
        this.id = id;
        this.table_id = table_id;
        this.numberInRestaurant = numberInRestaurant;
        this.numberOfSeats = numberOfSeats;
    }

    public static final class Builder {
        private long reservationItemId;
        private String restaurantName;
        private long id;
        private long table_id;
        private long numberInRestaurant;
        private long numberOfSeats;

        public ReservationItemDTO.Builder reservationItemId(long reservationItemId) {
            this.reservationItemId = reservationItemId;
            return this;
        }

        public ReservationItemDTO.Builder restaurantName(String restaurantName) {
            this.restaurantName = restaurantName;
            return this;
        }

        public ReservationItemDTO.Builder id(long id) {
            this.id = id;
            return this;
        }

        public ReservationItemDTO.Builder table_id(long table_id) {
            this.table_id = table_id;
            return this;
        }

        public ReservationItemDTO.Builder numberInRestaurant(long numberInRestaurant) {
            this.numberInRestaurant = numberInRestaurant;
            return this;
        }

        public ReservationItemDTO.Builder numberOfSeats(long numberOfSeats) {
            this.numberOfSeats = numberOfSeats;
            return this;
        }

        public ReservationItemDTO build() {
            ReservationItemDTO reservationItemDTO = new ReservationItemDTO();
            reservationItemDTO.reservationItemId = this.reservationItemId;
            reservationItemDTO.restaurantName = this.restaurantName;
            reservationItemDTO.id = this.id;
            reservationItemDTO.table_id = this.id;
            reservationItemDTO.numberInRestaurant = this.numberInRestaurant;
            reservationItemDTO.numberOfSeats = this.numberOfSeats;
            return reservationItemDTO;
        }
    }
}
