package com.example.petpal.service;

import com.example.petpal.dto.ReviewRequest;
import com.example.petpal.dto.ReviewResponse;
import com.example.petpal.model.Review;
import com.example.petpal.model.ReviewReply;
import com.example.petpal.repository.ReviewRepository;
import com.example.petpal.repository.ReviewReplyRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.example.petpal.entity.*;
import com.example.petpal.repository.CustomerRepository;
import com.example.petpal.repository.ServiceBookingRepository;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewReplyRepository reviewReplyRepository;

    private final ServiceBookingRepository bookingRepository;
    private final CustomerRepository customerRepository;

    ReviewService(ReviewRepository reviewRepository, ReviewReplyRepository reviewReplyRepository,
                    ServiceBookingRepository bookingRepository, CustomerRepository customerRepository
    ) {
        this.reviewRepository = reviewRepository;
        this.reviewReplyRepository = reviewReplyRepository;
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public List<ReviewResponse> listForCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new NotFoundException("Customer " + customerId + " was not found.");
        }
        return reviewRepository.findAllByCustomerIdOrderByReviewDateDescIdDesc(customerId)
                .stream().map(ReviewResponse::from).toList();
    }

public ReviewResponse create(Long customerId, Long bookingId, ReviewRequest request) {
         ServiceBooking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NotFoundException(
                        "Training booking " + bookingId + " was not found."));
        if (!booking.getCustomer().getId().equals(customerId)) {
            throw new NotFoundException("Service booking " + bookingId + " was not found for customer "
                    + customerId + ".");
        }
        if (!"COMPLETED".equalsIgnoreCase(booking.getStatus())) {
            throw new ConflictException("A review can only be submitted for a completed booking.");
        }
        if (booking.getReview() != null) {
            throw new ConflictException("A review already exists for this service booking.");
        }

        Review review = new Review();
        review.setBooking(booking);
        review.setCustomer(booking.getCustomer());
        review.setProvider(booking.getServiceEntity().getProvider());
        review.setRating(request.rating());
        review.setComment(request.comments());
        booking.setReview(review);
        return ReviewResponse.from(reviewRepository.save(review));
    }

    public List<Review> getReviewsByProvider(Long providerId) {
        return reviewRepository.findByProviderId(providerId);
    }

    public ReviewReply replyToReview(Long reviewId, ReviewReply reply) {
        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found with id: " + reviewId));
        reply.setReview(review);
        return reviewReplyRepository.save(reply);
    }
}