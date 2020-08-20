package com.mmkpdevelopers.freetable.controller;

import com.mmkpdevelopers.freetable.dao.UserRepository;
import com.mmkpdevelopers.freetable.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/addUser")
    @ResponseBody
    public void addUser(){
        userRepository.save(new User("Konrad", "Siekacz", "konrad@konrad", 22255));
    }

    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        return userRepository.findAll();
    }
}
