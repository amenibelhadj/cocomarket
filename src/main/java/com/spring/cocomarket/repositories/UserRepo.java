package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.SAV;
import com.spring.cocomarket.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepo  extends JpaRepository<User, Integer> {
    /*User findByFirstname (String firstname);

    @Transactional
    Long deleteByUsername(String firstname);*/
}
