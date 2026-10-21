package com.example.petpal.repository;

import com.example.petpal.model.ServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<ServiceEntity, Long> {
}
