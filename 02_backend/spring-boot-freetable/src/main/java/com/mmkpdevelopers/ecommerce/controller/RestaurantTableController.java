package com.mmkpdevelopers.ecommerce.controller;

import com.mmkpdevelopers.ecommerce.converter.RestaurantTableConverter;
import com.mmkpdevelopers.ecommerce.dao.RestaurantTableRepository;
import com.mmkpdevelopers.ecommerce.dto.RestaurantTableDTO;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import com.mmkpdevelopers.ecommerce.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class RestaurantTableController {
    private RestaurantTableService restaurantTableService;

    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

//    @GetMapping(value = "/tables", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public List<RestaurantTableDTO> getAllRestaurantsTable() {
//        return RestaurantTableConverter.entitiesToDto(restaurantTableService.getAllRestaurantTables());
//    }

    @GetMapping(value = "/tables", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<RestaurantTableDTO> getAllTables() {
        return RestaurantTableConverter.entitiesToDto(restaurantTableService.getAllRestaurantTables());
    }

    @GetMapping(value = "/tables/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public RestaurantTableDTO getRestaurantTableById(@PathVariable (value = "id") Long tableId) throws ResourceNotFoundException {
        RestaurantTable restaurantTable = restaurantTableService.getRestaurantTableById(tableId);
        return new RestaurantTableDTO(restaurantTable.getTableId(), restaurantTable.getId(),
                restaurantTable.getNumberInRestaurant(),
                restaurantTable.getNumberOfSeats());
    }

//    @GetMapping(value = "/tables/{id}", produces = APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public RestaurantTableDTO getRestaurantTableById(@PathVariable (value = "id") Long tableId){
//        return RestaurantTableConverter.entityToDto(restaurantTableService.getRestaurantTableById(tableId));
//    }

//    @GetMapping(value = "/tables/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public RestaurantTableDTO findRestaurantById(@PathVariable("id") Long id){
//        return RestaurantTableConverter.entityToDto(restaurantTableService.getRestaurantTableById(id));
//    }

    @PostMapping("/tables")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void addRestaurant(@RequestBody RestaurantTableDTO restaurantDTO){
        restaurantTableService.addRestaurantTable(RestaurantTableConverter.DtoToEntity(restaurantDTO));
    }

    @PutMapping("/tables")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateRestaurant(@RequestBody RestaurantTable restaurantTable) throws ResourceNotFoundException {
        restaurantTableService.updateRestaurantTable(restaurantTable);
    }

    @DeleteMapping("/tables/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRestaurant(@PathVariable("id")long id){
        restaurantTableService.deleteRestaurantTableById(id);
    }
    
    
//    RestaurantTable restaurantTable = new RestaurantTable();

//    @Autowired
//    private RestaurantTableRepository restaurantTableRepository;
//
//    @GetMapping("/tables")
//    public List<RestaurantTable> getAllTables(){
//        return restaurantTableRepository.findAll();
//    }
//
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