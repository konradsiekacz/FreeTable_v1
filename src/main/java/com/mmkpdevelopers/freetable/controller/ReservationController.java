package com.mmkpdevelopers.freetable.controller;

import com.mmkpdevelopers.freetable.dao.ReservationRepository;
import com.mmkpdevelopers.freetable.dao.RestaurantRepository;
import com.mmkpdevelopers.freetable.dao.TableRepository;
import com.mmkpdevelopers.freetable.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ReservationController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    TableRepository tableRepository;
    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    ReservationRepository reservationRepository;


    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/addReservations")
    @ResponseBody
    public void addReservation(){
    }
}
