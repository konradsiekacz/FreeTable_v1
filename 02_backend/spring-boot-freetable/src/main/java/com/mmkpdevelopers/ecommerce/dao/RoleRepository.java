package com.mmkpdevelopers.ecommerce.dao;

import java.util.Optional;

import com.mmkpdevelopers.ecommerce.entity.ERole;
import com.mmkpdevelopers.ecommerce.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin("http://localhost:4200")
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
