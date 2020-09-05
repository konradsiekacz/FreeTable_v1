package com.mmkpdevelopers.freetable.service;

import com.mmkpdevelopers.freetable.model.Customer;
import com.mmkpdevelopers.freetable.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private UserRepository repo;

    public List<Customer> listAll() {
        return repo.findAll();
    }

    public void save(Customer user) {
        repo.save(user);
    }

    public Customer get(int id) {
        return repo.findById(id).get();
    }


    public void delete(int id) {
        repo.deleteById(id);
    }


}
