//package com.mmkpdevelopers.freetable.controller;
//
//
//import com.mmkpdevelopers.freetable.dao.RestaurantRepository;
//import com.mmkpdevelopers.freetable.dao.TableRepository;
//import com.mmkpdevelopers.freetable.model.Restaurant;
//import com.mmkpdevelopers.freetable.model.Table;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.Collection;
//import java.util.Collections;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Controller
//public class RestaurantController {
//    @Autowired
//    TableRepository tableRepository;
//    @Autowired
//    RestaurantRepository restaurantRepository;
//
//    public RestaurantController(RestaurantRepository restaurantRepository, TableRepository tableRepository) {
//        this.restaurantRepository = restaurantRepository;
//        this.tableRepository = tableRepository;
//    }
//
//    @GetMapping("/addRestaurant")
//    @ResponseBody
//    public void addRest(){
//        restaurantRepository.save(new Restaurant("Marchewka", "ul.Ulicowa 2", tableRepository.findAll()));
//    }
//
//
//    @GetMapping("/getRes")
//    @ResponseBody
//    public List<Restaurant> getRestaurant(){
//       return restaurantRepository.findAll();
//    }
//
////    @GetMapping("/getRes")
////    @ResponseBody
////    public List<Restaurant> getRestaurant(){
////        List<Restaurant> restaurants = restaurantRepository.findAll().stream()
////                .flatMap(Collection::stream)
////                .collect(Collectors.toList());
////        return restaurants;
////    }
//
//
//}
