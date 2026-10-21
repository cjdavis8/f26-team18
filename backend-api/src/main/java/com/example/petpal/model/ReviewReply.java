package com.example.petpal.model;

import com.fasterxml.jackson.annotation.JsonBackReference; // 1. Add this import
import jakarta.persistence.*;

@Entity
@Table(name = "review_replies")
public class ReviewReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String replyText;
    
    @ManyToOne
    @JoinColumn(name = "review_id")
    @JsonBackReference // 2. Add this annotation here
    private Review review;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getReplyText() { return replyText; }
    public void setReplyText(String replyText) { this.replyText = replyText; }

    public Review getReview() { return review; }
    public void setReview(Review review) { this.review = review; }
}