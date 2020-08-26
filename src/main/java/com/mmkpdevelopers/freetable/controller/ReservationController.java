//package com.mmkpdevelopers.freetable.controller;
//
//import com.mmkpdevelopers.freetable.dao.ReservationRepository;
//import com.mmkpdevelopers.freetable.dao.RestaurantRepository;
//import com.mmkpdevelopers.freetable.dao.TableRepository;
//import com.mmkpdevelopers.freetable.dao.UserRepository;
//import com.mmkpdevelopers.freetable.model.Reservation;
//import com.mmkpdevelopers.freetable.model.Restaurant;
//import com.mmkpdevelopers.freetable.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.sql.Time;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//@Controller
//public class ReservationController {
//    @Autowired
//    UserRepository userRepository;
//    @Autowired
//    TableRepository tableRepository;
//    @Autowired
//    RestaurantRepository restaurantRepository;
//    @Autowired
//    ReservationRepository reservationRepository;
//
//
//    public ReservationController(ReservationRepository reservationRepository) {
//        this.reservationRepository = reservationRepository;
//        LocalDateTime now;
//    }
//
//
//
//    @GetMapping("/getRese")
//    @ResponseBody
//    public List<Restaurant> getRestaurant(){
//        return restaurantRepository.findAll();
//    }
//}
