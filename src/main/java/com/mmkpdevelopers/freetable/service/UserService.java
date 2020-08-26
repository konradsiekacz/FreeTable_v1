package com.mmkpdevelopers.freetable.service;
import com.mmkpdevelopers.freetable.dao.UserRepository;
import com.mmkpdevelopers.freetable.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAllUser(){
        List<User> users = new ArrayList<User>();
        userRepository.findAll().forEach(user1 -> users.add(user1));
        return users;
    }

    public User getUserById(int id){
        return userRepository.findById((long) id).get();
    }

    public void deleteUserById(int id){
        userRepository.deleteById((long) id);
    }

    public void updateUser(User user, int id){
        userRepository.save(user);
    }
}
