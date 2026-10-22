package com.example.petpal.controller;

import com.example.petpal.dto.*;
import com.example.petpal.service.*;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    private final BookingService bookingService;
    private final ReviewService reviewService;

    public CustomerController(
            CustomerService customerService,
            BookingService bookingService,
            ReviewService reviewService) {
        this.customerService = customerService;
        this.bookingService = bookingService;
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<CustomerResponse> register(
            @Valid @RequestBody CustomerRegistrationRequest request) {
        CustomerResponse customer = customerService.register(request);
        return ResponseEntity.created(URI.create("/api/customers/" + customer.id())).body(customer);
    }

    @GetMapping("/{customerId}")
    public CustomerResponse getProfile(@PathVariable Long customerId) {
        return customerService.getProfile(customerId);
    }

    @PutMapping("/{customerId}")
    public CustomerResponse updateProfile(
            @PathVariable Long customerId,
            @Valid @RequestBody CustomerUpdateRequest request) {
        return customerService.updateProfile(customerId, request);
    }

    @GetMapping("/{customerId}/services")
    public List<BookingServiceResponse> sessions(@PathVariable Long customerId) {
        return bookingService.listForCustomer(customerId);
    }

    @GetMapping("/{customerId}/reviews")
    public List<ReviewResponse> reviews(@PathVariable Long customerId) {
        return reviewService.listForCustomer(customerId);
    }

    @PostMapping("/{customerId}/subscriptions")
    public ResponseEntity<BookingServiceResponse> bookSession(
            @PathVariable Long customerId,
            @Valid @RequestBody BookingRequest request) {
        BookingServiceResponse session = bookingService.book(customerId, request);
        return ResponseEntity.created(URI.create("/api/customers/" + customerId
                + "/sessions/" + session.id())).body(session);
    }


    @PostMapping("/{customerId}/sessions/{sessionId}/review")
    public ResponseEntity<ReviewResponse> reviewSession(
            @PathVariable Long customerId,
            @PathVariable Long sessionId,
            @Valid @RequestBody ReviewRequest request) {
        ReviewResponse review = reviewService.create(customerId, sessionId, request);
        return ResponseEntity.created(URI.create("/api/trainers/" + review.providerId()
                + "/reviews/" + review.id())).body(review);
    }
}