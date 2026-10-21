package com.example.petpal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference; // 1. Add this import
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long providerId;
    private int rating;
    private String comment;
    
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    @JsonManagedReference // 2. Add this annotation here
    private List<ReviewReply> replies;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProviderId() { return providerId; }
    public void setProviderId(Long providerId) { this.providerId = providerId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public List<ReviewReply> getReplies() { return replies; }
    public void setReplies(List<ReviewReply> replies) { this.replies = replies; }
}
