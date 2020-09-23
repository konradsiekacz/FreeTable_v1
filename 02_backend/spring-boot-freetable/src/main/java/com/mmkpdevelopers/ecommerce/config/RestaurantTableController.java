package com.mmkpdevelopers.ecommerce.config;

import com.mmkpdevelopers.ecommerce.dao.RestaurantTableRepository;
import com.mmkpdevelopers.ecommerce.dto.RestaurantTableDto;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import com.mmkpdevelopers.ecommerce.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestaurantTableController {


//    private RestaurantTableRepository restaurantTableRepository;
    private RestaurantTableService restaurantTableService;

    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

    @GetMapping("/tables")
    public List<RestaurantTableDto> getAllTables(){
        return restaurantTableService.getAllRestaurantTables().stream()
                .map(table -> new RestaurantTableDto(table.getId(), table.getTableId(), table.getNumberInRestaurant(), table.getNumberInRestaurant())).collect(Collectors.toList());
    }

//    @GetMapping("/table/{id}")
//    public ResponseEntity<RestaurantTable> getRestaurantTableById(@PathVariable(value = "id") Long restaurantTableId)
//            throws ResourceNotFoundException {
//        RestaurantTable restaurantTable = restaurantTableRepository.findById(restaurantTableId)
//                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantTableId));
//        return ResponseEntity.ok().body(restaurantTable);
//    }
//
//    @PostMapping("/table")
//    public RestaurantTable createRestaurantTable(@Valid @RequestBody RestaurantTable restaurantTable){
//        return restaurantTableRepository.save(restaurantTable);
//    }
//
//    @PutMapping("/table/{id}")
//    public ResponseEntity<RestaurantTable> updateRestaurant(@PathVariable(value = "id") Long restaurantTableId,
//                                                       @Valid @RequestBody RestaurantTable restaurantTableDetails) throws ResourceNotFoundException {
//        RestaurantTable restaurantTable = restaurantTableRepository.findById(restaurantTableId)
//                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantTableId));
//
//        restaurantTable.setId(restaurantTableDetails.getId());
//        restaurantTable.setTableId(restaurantTableDetails.getTableId());
//        restaurantTable.setNumberInRestaurant(restaurantTableDetails.getNumberInRestaurant());
//        restaurantTable.setNumberOfSeats(restaurantTableDetails.getNumberOfSeats());
//        final RestaurantTable updateRestaurantTable = restaurantTableRepository.save(restaurantTable);
//        return ResponseEntity.ok(updateRestaurantTable);
//    }
}
