package com.mmkpdevelopers.freetable.controller;

import com.mmkpdevelopers.freetable.model.User;
import com.mmkpdevelopers.freetable.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/saveUser")
    private int saveUser(@RequestBody User user){
        userService.saveUser(user);
        return user.getId().intValue();
    }

    @GetMapping("/getUsers")
    @ResponseBody
    private List<User> getUsers(){
       return userService.getAllUser();
    }

    @GetMapping("/getUser/{id}")
    @ResponseBody
    private User getUser(@PathVariable("id") int id)
    {
        return userService.getUserById(id);
    }

    @DeleteMapping("/deleteUser/{id}")
    @ResponseBody
    private void deleteUser(@PathVariable("id") int id)
    {
        userService.deleteUserById(id);
    }

    @PutMapping("/updateUser/{id}")
    @ResponseBody
    private User update(@RequestBody User user, @PathVariable("id") int id)
    {
        userService.updateUser(user,id);
        return user;
    }
}
