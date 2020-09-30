package com.mmkpdevelopers.ecommerce.service;

import com.mmkpdevelopers.ecommerce.dao.UserRepository;
import com.mmkpdevelopers.ecommerce.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User updateUser) {
        User existingUser = getUserById(updateUser.getId());
        existingUser.setName(updateUser.getName());
        existingUser.setSurname(existingUser.getSurname());
        existingUser.setEmail(updateUser.getEmail());
        existingUser.setPhoneNumber(existingUser.getPhoneNumber());
        existingUser.setImageUrl(existingUser.getImageUrl());
        userRepository.save(existingUser);
    }

    public void deleteUser(Long id) {
        userRepository.deleteUserById(id);
    }
}
