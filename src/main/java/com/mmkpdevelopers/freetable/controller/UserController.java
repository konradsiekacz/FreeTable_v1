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

    @PutMapping("/updateUser")
    @ResponseBody
    private User update(@RequestBody User user)
    {
        userService.saveUser(user);
        return user;
    }



//    @Autowired
//    UserRepository userRepository;
//
//    public UserController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @GetMapping("/addUser")
//    @ResponseBody
//    public void addUser(){
//        userRepository.save(new User("Konrad", "Siekacz", "konrad@konrad", 22255));
//        userRepository.save(new User("Martin", "Zack","martin@martin",234262));
//    }
//
//    @GetMapping("/getUser")
//    @ResponseBody
//    public List<User> getUser(){
//        return userRepository.findAll();
//    }
//
//    @GetMapping("/getUser/{id}")
//    @ResponseBody
//    public User getUserById(@PathVariable String id){
//        Optional<User> user = userRepository.findById(Long.parseLong(id));
//        if(!user.isPresent()) {
//            throw new UserNotFoundException("id-" + id);
//        }
//        return user.get();
//    }
//
//    @GetMapping("/deleteUser/{id}")
//    @ResponseBody
//    public void deleteUserById(@PathVariable String id){
//        userRepository.deleteById(Long.parseLong(id));
//    }
//
//    @GetMapping("update{id}Name{name}")
//    @ResponseBody
//    public ResponseEntity<Object> updateUser(@RequestBody User user, @PathVariable long id, @PathVariable String name) {
//
//        Optional<User> userOptional = userRepository.findById(id);
//
//        if (!userOptional.isPresent())
//            return ResponseEntity.notFound().build();
//
//        user.setName(name);
//        userRepository.save(user);
//        return ResponseEntity.noContent().build();
//    }

}
