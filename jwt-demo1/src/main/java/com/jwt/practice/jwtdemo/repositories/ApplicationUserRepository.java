package com.jwt.practice.jwtdemo.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.jwt.practice.jwtdemo.models.ApplicationUser;

@Repository
public interface  ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    ApplicationUser findByUsername(String username);

}
