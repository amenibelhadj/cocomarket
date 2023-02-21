package com.spring.cocomarket.repositories;

import com.spring.cocomarket.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, PagingAndSortingRepository<User,Integer> {
    //public User findByEmail(String email);
    Page<User> findAll(Specification<User> spec, Pageable pageable);
    List<User> findAll(Specification<User> spec, Sort sort);
     Optional<User> findByEmail(String email);
}
