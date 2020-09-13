package com.mmkpdevelopers.freetable.controller;

import com.mmkpdevelopers.freetable.model.Restaurant;
import com.mmkpdevelopers.freetable.service.RestaurantService;
import com.mmkpdevelopers.freetable.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
public class RestaurantController {
    @Autowired
    TableService tableService;
    @Autowired
    RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService, TableService tableService) {
        this.restaurantService = restaurantService;
        this.tableService = tableService;
    }

    @PostMapping("/saveRest")
    @ResponseBody
    private int saveRest(@RequestBody Restaurant restaurant){
        restaurantService.saveReustaurant(restaurant);
        return restaurant.getId().intValue();
    }

    @GetMapping("/getRest")
    @ResponseBody
    private List<Restaurant> getRestaurants(){
        return restaurantService.getRestaurants();
    }

    @GetMapping("/getRest/{id}")
    @ResponseBody
    private Restaurant getRestaurant(@PathVariable("id") int id)
    {
        return restaurantService.getRestaurantById(id);
    }

    @DeleteMapping("/deleteRest/{id}")
    @ResponseBody
    private void deleteRestaurant(@PathVariable("id") int id)
    {
        restaurantService.deleteRestaurantById(id);
    }

    @PutMapping("/updateRest/{id}")
    @ResponseBody
    private Restaurant update(@RequestBody Restaurant restaurant, @PathVariable("id") int id)
    {
        restaurantService.updateRestaurant(restaurant, id);
        return restaurant;
    }
}
