package com.example.petpal.controller;

import com.example.petpal.dto.*;
import com.example.petpal.service.*;
import com.example.petpal.repository.CustomerRepository;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class PetController {
    private final PetService petService;
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public PetController(
            PetService petService,
            CustomerService customerService,
            CustomerRepository customerRepository) {
        this.petService = petService;
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    @PostMapping
    public ResponseEntity<PetResponse> registerPet(
            @Valid @RequestBody PetRegistrationRequest request) {
        PetResponse pet = petService.register(customerService.findCustomer(request.customerId()), request);
        return ResponseEntity.created(URI.create("/api/pets/" + pet.id())).body(pet);
    }

    @GetMapping("/{petId}")
    public PetResponse getProfile(@PathVariable Long petId) {
        return petService.getProfile(petId);
    }

    @PutMapping("/{petId}")
    public PetResponse updateProfile(
            @PathVariable Long petId,
            @Valid @RequestBody PetUpdateRequest request) {
        return petService.updateProfile(petId, request);
    }
}
