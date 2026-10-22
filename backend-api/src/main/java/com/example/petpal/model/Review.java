package com.example.petpal.model;

import com.fasterxml.jackson.annotation.JsonManagedReference; // 1. Add this import
import jakarta.persistence.*;
import java.util.List;

import com.example.petpal.entity.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Long providerId;
    private int rating;
    private String comment;

    private Customer customer;
    private Provider provider;
    private ServiceBooking booking;
    
    @OneToMany(mappedBy = "review", cascade = CascadeType.ALL)
    @JsonManagedReference // 2. Add this annotation here
    private List<ReviewReply> replies;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getProviderId() { return providerId; }
    public void setProviderId(Long providerId) { this.providerId = providerId; }

    public Customer getCustomer() { return customer;}
    public void setCustomer(Customer customer) { this.customer = customer; }

    public Provider getProvider() { return provider;}
    public void setProvider(Provider provider) { this.provider = provider; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public List<ReviewReply> getReplies() { return replies; }
    public void setReplies(List<ReviewReply> replies) { this.replies = replies; }

    public ServiceBooking getBooking() { return booking; }
    public void setBooking(ServiceBooking booking) {this.booking = booking;}

    
}
