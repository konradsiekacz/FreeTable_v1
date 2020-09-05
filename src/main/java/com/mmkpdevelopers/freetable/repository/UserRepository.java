package com.mmkpdevelopers.freetable.repository;

import com.mmkpdevelopers.freetable.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Customer, Integer> {
}
