package com.example.petpal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference; // 1. Add this import
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;
import java.util.List;

import com.example.petpal.entity.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int rating;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    private Provider provider;

    @NotNull
    @Column(nullable = false, updatable = false)
    private LocalDateTime reviewDate;

    @OneToOne(mappedBy = "review")
    private ServiceBooking booking;
    
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    @JsonManagedReference // 2. Add this annotation here
    private List<ReviewReply> replies;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }


    public Customer getCustomer() { return customer;}
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Provider getProvider() { return provider;}
    public void setProvider(Provider provider) { this.provider = provider; }

    public LocalDateTime getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDateTime reviewDate) {
        this.reviewDate = reviewDate;
    }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public List<ReviewReply> getReplies() { return replies; }
    public void setReplies(List<ReviewReply> replies) { this.replies = replies; }

    public ServiceBooking getBooking() { return booking; }
    public void setBooking(ServiceBooking booking) {this.booking = booking;}

    
}
