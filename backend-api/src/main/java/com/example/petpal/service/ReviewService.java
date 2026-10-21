package com.example.petpal.service;

import com.example.petpal.model.Review;
import com.example.petpal.model.ReviewReply;
import com.example.petpal.repository.ReviewRepository;
import com.example.petpal.repository.ReviewReplyRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    private final ReviewReplyRepository reviewReplyRepository;

    ReviewService(ReviewRepository reviewRepository, ReviewReplyRepository reviewReplyRepository) {
        this.reviewRepository = reviewRepository;
        this.reviewReplyRepository = reviewReplyRepository;
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