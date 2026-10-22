package com.example.petpal.dto;

import com.example.petpal.model.Review;

import java.time.LocalDateTime;

public record ReviewResponse(
        Long id,
        Integer rating,
        String comments,
        Long customerId,
        String customerName,
        Long providerId,
        String providerName,
        Long bookingId) {

    public static ReviewResponse from(Review review) {
        return new ReviewResponse(review.getId(), review.getRating(), review.getComment(),
                review.getCustomer().getId(),
                review.getCustomer().getName(), review.getProvider().getId(),
                review.getProvider().getName(),
                review.getBooking().getId());
    }
}