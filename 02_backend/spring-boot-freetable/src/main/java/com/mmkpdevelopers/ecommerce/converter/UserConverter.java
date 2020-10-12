package com.mmkpdevelopers.ecommerce.converter;

import com.mmkpdevelopers.ecommerce.dto.UserDTO;
import com.mmkpdevelopers.ecommerce.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserConverter {
    public static UserDTO entityToDto(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setPassword(user.getPassword());
        userDTO.setEmail(user.getEmail());
        return userDTO;
    }

    public static List<UserDTO> entitiesToDto(List<User> users) {
        return users.stream()
                .map(UserConverter::entityToDto)
                .collect(Collectors.toList());
    }

    public static User dtoToEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setPassword(userDTO.getPassword());
        user.setPassword(userDTO.getPassword());
        user.setEmail(userDTO.getEmail());
        return user;
    }
}
