package com.example.petpal.repository;

import com.example.petpal.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    // Look up reviews by provider ID
    List<Review> findByProviderId(Long providerId);

    // Optimized lookup for provider profiles with replies eagerly fetched
    @Query("SELECT r FROM Review r LEFT JOIN FETCH r.replies WHERE r.provider.id = :providerId")
    List<Review> findByProviderIdWithReplies(@Param("providerId") Long providerId);

    // Look up reviews by customer ID (note the underscore: Customer_Id)
    List<Review> findAllByCustomerIdOrderByReviewDateDescIdDesc(Long customerId);
}