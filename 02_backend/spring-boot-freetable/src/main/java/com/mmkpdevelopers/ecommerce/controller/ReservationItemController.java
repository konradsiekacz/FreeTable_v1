package com.mmkpdevelopers.ecommerce.controller;

import com.mmkpdevelopers.ecommerce.converter.ReservationItemConverter;
import com.mmkpdevelopers.ecommerce.converter.RestaurantConverter;
import com.mmkpdevelopers.ecommerce.dao.ReservationItemRepository;
import com.mmkpdevelopers.ecommerce.dto.ReservationItemDTO;
import com.mmkpdevelopers.ecommerce.dto.RestaurantDTO;
import com.mmkpdevelopers.ecommerce.dto.RestaurantTableDTO;
import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import com.mmkpdevelopers.ecommerce.entity.Restaurant;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import com.mmkpdevelopers.ecommerce.exception.ResourceNotFoundException;
import com.mmkpdevelopers.ecommerce.service.ReservationItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReservationItemController {

    final ReservationItemService reservationItemService;

    public ReservationItemController(ReservationItemService reservationItemService) {
        this.reservationItemService = reservationItemService;
    }

    @GetMapping(value = "/reservationItems", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<ReservationItemDTO> getAllReservations() {
        return ReservationItemConverter.entitiesToDto(reservationItemService.getAllReservationItems());
    }

//    @GetMapping(value = "/reservationItems/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public ReservationItemDTO findReservationById(@PathVariable("id") Long id){
//        return ReservationItemConverter.entityToDto(reservationItemService.getReservationItemById(id));
//    }

    @GetMapping(value = "/reservationItems/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ReservationItemDTO getRestaurantTableById(@PathVariable (value = "id") Long id) throws ResourceNotFoundException {
        ReservationItem reservationItem = reservationItemService.getReservationItemById(id);
        return new ReservationItemDTO(reservationItem.getReservationItemId(),
                reservationItem.getRestaurantName(),
                reservationItem.getId(),
                reservationItem.getTable_id(),
                reservationItem.getNumberInRestaurant(),reservationItem.getNumberOfSeats());
    }

    @PostMapping("/reservationItems")
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void addReservation(@RequestBody ReservationItemDTO reservationItemDTO){
        reservationItemService.addReservationItem(ReservationItemConverter.dtoToEntity(reservationItemDTO));
    }

    @PutMapping("/reservationItems")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateReservation(@RequestBody ReservationItem reservationItem) throws ResourceNotFoundException {
        reservationItemService.updateReservationItem(reservationItem);
    }

    @DeleteMapping("/reservationItems/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReservation(@PathVariable("id")long id){
        reservationItemService.deleteReservationItem(id);
    }

    //    final ReservationItemRepository reservationItemRepository;
//
//    public ReservationItemController(ReservationItemRepository reservationItemRepository) {
//        this.reservationItemRepository = reservationItemRepository;
//    }


//    @GetMapping("/reservationItems")
//    public List<ReservationItem> getAllReservationItems(){
//        return reservationItemRepository.findAll();
//    }
//
//    @PostMapping("/reservationItems")
//    public List<ReservationItem> createReservationItems(@Valid @RequestBody List<ReservationItem> reservationItems) {
//        return reservationItemRepository.saveAll(reservationItems);
//    }





}
