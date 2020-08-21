package com.mmkpdevelopers.freetable.controller;

import com.mmkpdevelopers.freetable.dao.UserRepository;
import com.mmkpdevelopers.freetable.exceptions.UserNotFoundException;
import com.mmkpdevelopers.freetable.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

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
        userRepository.save(new User("Martin", "Zack","martin@martin",234262));
    }

    @GetMapping("/getUser")
    @ResponseBody
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @GetMapping("/getUser/{id}")
    @ResponseBody
    public User getUserById(@PathVariable String id){
        Optional<User> user = userRepository.findById(Long.parseLong(id));
        if(!user.isPresent()) {
            throw new UserNotFoundException("id-" + id);
        }
        return user.get();
    }

    @GetMapping("/deleteUser/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable String id){
        userRepository.deleteById(Long.parseLong(id));
    }

    @PutMapping("update{id}Name{name}")
    @ResponseBody
    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id, @PathVariable String name) {

        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return ResponseEntity.notFound().build();

        user.setName(name);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}
