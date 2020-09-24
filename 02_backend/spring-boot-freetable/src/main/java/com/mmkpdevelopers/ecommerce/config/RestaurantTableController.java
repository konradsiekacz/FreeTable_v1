package com.mmkpdevelopers.ecommerce.config;

import com.mmkpdevelopers.ecommerce.converter.RestaurantTableConverter;
import com.mmkpdevelopers.ecommerce.dao.RestaurantTableRepository;
import com.mmkpdevelopers.ecommerce.dto.RestaurantTableDto;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import com.mmkpdevelopers.ecommerce.service.RestaurantTableService;
import io.micrometer.core.ipc.http.OkHttpSender;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestaurantTableController {


    private RestaurantTableService restaurantTableService;
    private RestaurantTableConverter restaurantTableConverter;

    public RestaurantTableController(RestaurantTableService restaurantTableService,
                                     RestaurantTableConverter restaurantTableConverter) {

        this.restaurantTableService = restaurantTableService;
        this.restaurantTableConverter = restaurantTableConverter;
    }

    @GetMapping(value = "/tables", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantTableDto> getAllTables() {
        return restaurantTableConverter.entitiesToDto(restaurantTableService.getAllRestaurantTables());
    }

    @GetMapping(value = "table/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public RestaurantTableDto getRestaurantTableById(@PathVariable Long id) throws ResourceNotFoundException {
        RestaurantTable restaurantTable = restaurantTableService.getRestaurantTable(id);
        return new RestaurantTableDto(restaurantTable.getId(), restaurantTable.getTableId(),
                restaurantTable.getNumberInRestaurant(),
                restaurantTable.getNumberOfSeats());
    }

    //    @GetMapping("/table/{id}")
//    public ResponseEntity<RestaurantTable> getRestaurantTableById(@PathVariable(value = "id") Long restaurantTableId)
//            throws ResourceNotFoundException {
//        RestaurantTable restaurantTable = restaurantTableRepository.findById(restaurantTableId)
//                .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantTableId));
//        return ResponseEntity.ok().body(restaurantTable);
//    }
//
    @PostMapping("/table")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public RestaurantTable createRestaurantTable(@Valid @RequestBody RestaurantTableDto restaurantTableDto) {
        return restaurantTableService.addRestaurantTable(restaurantTableConverter.DtoToEntity(restaurantTableDto));
    }
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
