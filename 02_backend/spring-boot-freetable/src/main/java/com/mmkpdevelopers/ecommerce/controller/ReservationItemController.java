package com.mmkpdevelopers.ecommerce.controller;

import com.mmkpdevelopers.ecommerce.dao.ReservationItemRepository;
import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReservationItemController {


    final ReservationItemRepository reservationItemRepository;

    public ReservationItemController(ReservationItemRepository reservationItemRepository) {
        this.reservationItemRepository = reservationItemRepository;
    }

    @GetMapping("/reservationItems")
    public List<ReservationItem> getAllReservationItems(){
        return reservationItemRepository.findAll();
    }

    @PostMapping("/reservationItems")
    public List<ReservationItem> createReservationItems(@Valid @RequestBody List<ReservationItem> reservationItems) {
        return reservationItemRepository.saveAll(reservationItems);
    }





}
