package com.mmkpdevelopers.freetable.service;

import com.mmkpdevelopers.freetable.dao.RestaurantRepository;
import com.mmkpdevelopers.freetable.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository restaurantRepository;

    public void saveReustaurant(Restaurant restaurant){
        restaurantRepository.save(restaurant);
    }

    public List<Restaurant> getRestaurants(){
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurantRepository.findAll().forEach(restaurant -> restaurants.add(restaurant));
        return restaurants;
    }

    public Restaurant getRestaurantById(int id){
        return restaurantRepository.findById((long) id).get();
    }

    public void deleteRestaurantById(int id){
        restaurantRepository.deleteById((long) id);
    }

    public void updateRestaurant(Restaurant restaurant, int id){
        restaurantRepository.save(restaurant);
    }
}
