package com.example.petpal.repository;

import com.example.petpal.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean existsByEmailIgnoreCase(String email);
}