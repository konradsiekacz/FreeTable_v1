package com.mmkpdevelopers.ecommerce.config;

import com.mmkpdevelopers.ecommerce.dao.RestaurantRepository;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;



	@GetMapping("/restaurants")
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@GetMapping("/restaurants/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(value = "id") Long restaurantId)
			throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));
		return ResponseEntity.ok().body(restaurant);
	}

	@PostMapping("/restaurants")
	public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@PutMapping("/restaurants/{id}")
	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") Long restaurantId,
			@Valid @RequestBody Restaurant restaurantDetails) throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));

		restaurant.setId(restaurantDetails.getId());
		restaurant.setName(restaurantDetails.getName());
		restaurant.setAddress(restaurantDetails.getAddress());
		restaurant.setImageUrl(restaurantDetails.getImageUrl());
		restaurant.setAveragePriceForMeal(restaurantDetails.getAveragePriceForMeal());
		final Restaurant updateRestaurant = restaurantRepository.save(restaurant);
		return ResponseEntity.ok(updateRestaurant);
	}

	@DeleteMapping("/restaurants/{id}")
	public Map<String, Boolean> deleteRestaurant(@PathVariable(value = "id") Long restaurantId)
			throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));

		restaurantRepository.delete(restaurant);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
