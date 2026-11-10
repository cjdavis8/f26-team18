package com.example.petpal.repository;

import com.example.petpal.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProviderRepository extends JpaRepository<Provider, Long> {

    // Find a provider profile by their linked user ID
    Optional<Provider> findByUserId(Long userId);

    // Find a provider by their email address
    Optional<Provider> findByEmail(String email);

    // Useful for validation during profile creation/updates
    boolean existsByEmail(String email);
}
