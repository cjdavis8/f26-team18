package com.example.petpal.repository;

import com.example.petpal.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByProviderId(Long providerId);

    List<Review> findAllByCustomerIdOrderByReviewDateDescIdDesc(Long customerId);
}
