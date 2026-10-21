package com.example.petpal.controller;

import com.example.petpal.model.Review;
import com.example.petpal.model.ReviewReply;
import com.example.petpal.service.ReviewService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ReviewController {

    private final ReviewService reviewService;

    ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/providers/{id}/reviews")
    public ResponseEntity<List<Review>> getProviderReviews(@PathVariable Long id) {
        return ResponseEntity.ok(reviewService.getReviewsByProvider(id));
    }

    @PostMapping("/reviews/{reviewId}/replies")
    public ResponseEntity<ReviewReply> replyToReview(@PathVariable Long reviewId, @RequestBody ReviewReply reply) {
        return ResponseEntity.ok(reviewService.replyToReview(reviewId, reply));
    }
}
