package com.mmkpdevelopers.ecommerce.converter;

import com.mmkpdevelopers.ecommerce.dto.RestaurantTableDTO;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantTableConverter {
    public static RestaurantTableDTO entityToDto(RestaurantTable restaurantTable) {
        RestaurantTableDTO restaurantTableDTO = new RestaurantTableDTO();
        restaurantTableDTO.setTableId(restaurantTable.getTableId());
        restaurantTableDTO.setId(restaurantTable.getId());
        restaurantTableDTO.setNumberInRestaurant(restaurantTable.getNumberInRestaurant());
        restaurantTableDTO.setNumberOfSeats(restaurantTable.getNumberOfSeats());
        return restaurantTableDTO;
    }

    public static List<RestaurantTableDTO> entitiesToDto(List<RestaurantTable> restaurantTables) {
        return restaurantTables.stream()
                .map(restaurantTable -> entityToDto(restaurantTable))
                .collect(Collectors.toList());
    }

    public static RestaurantTable DtoToEntity(RestaurantTableDTO restaurantTableDTO) {
        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setTableId(restaurantTableDTO.getTableId());
        restaurantTable.setId(restaurantTableDTO.getId());
        restaurantTable.setNumberInRestaurant(restaurantTableDTO.getNumberInRestaurant());
        restaurantTable.setNumberOfSeats(restaurantTableDTO.getNumberOfSeats());
        return restaurantTable;
    }
}
