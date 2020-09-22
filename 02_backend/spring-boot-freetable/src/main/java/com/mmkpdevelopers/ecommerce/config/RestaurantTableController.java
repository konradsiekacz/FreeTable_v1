package com.mmkpdevelopers.ecommerce.config;

import com.mmkpdevelopers.ecommerce.dao.RestaurantTableRepository;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class RestaurantTableController {
    RestaurantTable restaurantTable = new RestaurantTable();

    @Autowired
    private RestaurantTableRepository restaurantTableRepository;

    @GetMapping("/tables")
    public List<RestaurantTable> getAllTables(){
        return restaurantTableRepository.findAll();
    }

    @GetMapping("/table/{id}")
    public ResponseEntity<RestaurantTable> getRestaurantTableById(@PathVariable(value = "id") Long restaurantTableId)
            throws ResourceNotFoundException {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(restaurantTableId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantTableId));
        return ResponseEntity.ok().body(restaurantTable);
    }

    @PostMapping("/table")
    public RestaurantTable createRestaurantTable(@Valid @RequestBody RestaurantTable restaurantTable){
        return restaurantTableRepository.save(restaurantTable);
    }

    @PutMapping("/table/{id}")
    public ResponseEntity<RestaurantTable> updateRestaurant(@PathVariable(value = "id") Long restaurantTableId,
                                                       @Valid @RequestBody RestaurantTable restaurantTableDetails) throws ResourceNotFoundException {
        RestaurantTable restaurantTable = restaurantTableRepository.findById(restaurantTableId)
                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantTableId));

        restaurantTable.setId(restaurantTableDetails.getId());
        restaurantTable.setTableId(restaurantTableDetails.getTableId());
        restaurantTable.setNumberInRestaurant(restaurantTableDetails.getNumberInRestaurant());
        restaurantTable.setNumberOfSeats(restaurantTableDetails.getNumberOfSeats());
        final RestaurantTable updateRestaurantTable = restaurantTableRepository.save(restaurantTable);
        return ResponseEntity.ok(updateRestaurantTable);
    }
}
