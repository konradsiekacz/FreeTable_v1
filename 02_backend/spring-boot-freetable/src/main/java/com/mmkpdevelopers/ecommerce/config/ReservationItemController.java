package com.mmkpdevelopers.ecommerce.config;

import com.mmkpdevelopers.ecommerce.converter.ReservationItemConverter;
import com.mmkpdevelopers.ecommerce.dao.ReservationItemRepository;
import com.mmkpdevelopers.ecommerce.dto.ReservationItemDTO;
import com.mmkpdevelopers.ecommerce.entity.ReservationItem;
import com.mmkpdevelopers.ecommerce.service.ReservationItemService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ReservationItemController {


//    final ReservationItemService reservationItemService;
//
//    public ReservationItemController(ReservationItemService reservationItemService) {
//        this.reservationItemService = reservationItemService;
//    }
//
//    @GetMapping(value = "/reservationItems", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @ResponseStatus(HttpStatus.OK)
//    public List<ReservationItemDTO> getAllReservations() {
//        return ReservationItemConverter.entitiesToDto(reservationItemService.getAllReservationItems());
//    }
//    @GetMapping("/reservationItems/{id}")
//    public List<ReservationItemDTO> getReservationItemsById(@PathVariable(value = "id") Long id)
//            throws ResourceNotFoundException {
//        return ReservationItemConverter.entitiesToDto(reservationItemService.findReservationItemById(id));
//    }
//
//    @PostMapping("/reservationItems")
//    @ResponseBody
//    @ResponseStatus(HttpStatus.CREATED)
//    public void saveReservation(@RequestBody ReservationItemDTO reservationItemDTO){
//        reservationItemService.saveReservationItem(ReservationItemConverter.dtoToEntity(reservationItemDTO));
//    }

    final ReservationItemRepository reservationItemRepository;

    public ReservationItemController(ReservationItemRepository reservationItemRepository) {
        this.reservationItemRepository = reservationItemRepository;
    }

    @GetMapping("/reservationItems")
    public List<ReservationItem> getAllReservationItems(){
        return reservationItemRepository.findAll();
    }

    @PostMapping("/reservationItems")
    public List<ReservationItem> createReservationItems(@Valid @RequestBody List<ReservationItem> reservationItems) {
        return reservationItemRepository.saveAll(reservationItems);
    }
    @GetMapping("/reservationItems/{id}")
    public List<ReservationItem> getReservationItemsById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        return reservationItemRepository.findReservationItemsById(id);
    }



}
