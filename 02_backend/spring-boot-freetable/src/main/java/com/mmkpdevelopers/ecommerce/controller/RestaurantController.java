package com.mmkpdevelopers.ecommerce.controller;

import com.mmkpdevelopers.ecommerce.converter.RestaurantConverter;
import com.mmkpdevelopers.ecommerce.dto.RestaurantDTO;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import com.mmkpdevelopers.ecommerce.service.RestaurantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestaurantController {
	private RestaurantService restaurantService;

	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@GetMapping(value = "/restaurants", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public List<RestaurantDTO> getAllRestaurants() {
		return RestaurantConverter.entitiesToDto(restaurantService.getAllRestaurants());
	}
	
	@GetMapping(value = "/restaurants/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public RestaurantDTO findRestaurantById(@PathVariable("id") Long id){
		return RestaurantConverter.entityToDto(restaurantService.getRestaurantById(id));
	}

	@PostMapping("/restaurants")
	@ResponseBody
	@ResponseStatus(HttpStatus.CREATED)
	public void addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
		restaurantService.addRestaurant(RestaurantConverter.dtoToEntity(restaurantDTO));
	}

	@PutMapping("/restaurants")
	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	public void updateRestaurant(@RequestBody Restaurant restaurant){
		restaurantService.updateRestaurant(restaurant);
	}

	@DeleteMapping("/restaurants/{id}")
	@ResponseBody
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteRestaurant(@PathVariable("id")long id){
		restaurantService.deleteRestaurantById(id);
	}

	//	@Autowired
//	private RestaurantRepository restaurantRepository;
//
//
//
//	@GetMapping("/restaurants")
//	public List<Restaurant> getAllRestaurants() {
//		return restaurantRepository.findAll();
//	}
//
//	@GetMapping("/restaurants/{id}")
//	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(value = "id") Long restaurantId)
//			throws ResourceNotFoundException {
//		Restaurant restaurant = restaurantRepository.findById(restaurantId)
//				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));
//		return ResponseEntity.ok().body(restaurant);
//	}
//
//	@PostMapping("/restaurants")
//	public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant) {
//		return restaurantRepository.save(restaurant);
//	}
//
//	@PutMapping("/restaurants/{id}")
//	public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") Long restaurantId,
//			@Valid @RequestBody Restaurant restaurantDetails) throws ResourceNotFoundException {
//		Restaurant restaurant = restaurantRepository.findById(restaurantId)
//				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));
//
//		restaurant.setId(restaurantDetails.getId());
//		restaurant.setName(restaurantDetails.getName());
//		restaurant.setAddress(restaurantDetails.getAddress());
//		restaurant.setImageUrl(restaurantDetails.getImageUrl());
//		restaurant.setAveragePriceForMeal(restaurantDetails.getAveragePriceForMeal());
//		final Restaurant updateRestaurant = restaurantRepository.save(restaurant);
//		return ResponseEntity.ok(updateRestaurant);
//	}
//
//	@DeleteMapping("/restaurants/{id}")
//	public Map<String, Boolean> deleteRestaurant(@PathVariable(value = "id") Long restaurantId)
//			throws ResourceNotFoundException {
//		Restaurant restaurant = restaurantRepository.findById(restaurantId)
//				.orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));
//
//		restaurantRepository.delete(restaurant);
//		Map<String, Boolean> response = new HashMap<>();
//		response.put("deleted", Boolean.TRUE);
//		return response;
//	}
}
