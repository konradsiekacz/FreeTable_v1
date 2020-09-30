package com.mmkpdevelopers.ecommerce.dao;

import com.mmkpdevelopers.ecommerce.entity.User;
import org.apache.tomcat.util.buf.UEncoder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("http://localhost:4200")
public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);

    User deleteUserById(Long id);
}
