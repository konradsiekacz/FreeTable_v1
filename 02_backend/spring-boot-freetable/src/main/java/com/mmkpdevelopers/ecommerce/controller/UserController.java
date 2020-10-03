package com.mmkpdevelopers.ecommerce.controller;

import com.mmkpdevelopers.ecommerce.converter.UserConverter;
import com.mmkpdevelopers.ecommerce.dto.UserDTO;
import com.mmkpdevelopers.ecommerce.entity.User;
import com.mmkpdevelopers.ecommerce.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getAllUsers() {
        return UserConverter.entitiesToDto(userService.getAllUsers());
    }

    @GetMapping(value = "/users/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findUserById(@PathVariable("id") Long id){
        return UserConverter.entityToDto(userService.getUserById(id));
    }

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public void addUser(@RequestBody UserDTO userDTO){
        userService.addUser(UserConverter.dtoToEntity(userDTO));
    }

    @PutMapping("/users")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody User user){
        userService.updateUser(user);
    }

    @Transactional
    @DeleteMapping("/users/{id}")
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id")Long id){
        userService.deleteUser(id);
    }
}
