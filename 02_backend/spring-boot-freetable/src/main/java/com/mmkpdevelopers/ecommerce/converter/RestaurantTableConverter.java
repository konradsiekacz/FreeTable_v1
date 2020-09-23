package com.mmkpdevelopers.ecommerce.converter;

import com.mmkpdevelopers.ecommerce.dto.RestaurantTableDto;
import com.mmkpdevelopers.ecommerce.entity.RestaurantTable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RestaurantTableConverter {
    public RestaurantTableDto entityToDto(RestaurantTable restaurantTable){
        RestaurantTableDto restaurantTableDto = new RestaurantTableDto();
        restaurantTableDto.setId(restaurantTable.getId());
        restaurantTableDto.setTableId(restaurantTable.getTableId());
        restaurantTableDto.setNumberInRestaurant(restaurantTable.getNumberInRestaurant());
        restaurantTableDto.setNumberOfSeats(restaurantTable.getNumberOfSeats());
        return restaurantTableDto;
    }

    public List<RestaurantTableDto> entitiesToDto(List<RestaurantTable> restaurantTables){
        return restaurantTables.stream()
                .map(restaurantTable -> entityToDto(restaurantTable))
                .collect(Collectors.toList());
    }

    public RestaurantTable DtoToEntity(RestaurantTableDto restaurantTableDto){
        RestaurantTable restaurantTable = new RestaurantTable();
        restaurantTable.setId(restaurantTableDto.getId());
        restaurantTable.setTableId(restaurantTableDto.getTableId());
        restaurantTable.setNumberInRestaurant(restaurantTable.getNumberOfSeats());
        restaurantTable.setNumberOfSeats(restaurantTableDto.getNumberOfSeats());
        return  restaurantTable;
    }
}
