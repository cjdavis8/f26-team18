package com.example.petpal.controller;

import com.example.petpal.model.Provider;
import com.example.petpal.service.ProviderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {
    // Service injection

    private final ProviderService providerService;

    // Constructor-based injection for the Service
    public ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    // 1. GET ALL: Fetch a list of all provider profiles
    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders() {
        List<Provider> providers = providerService.getAllProviders();
        return ResponseEntity.ok(providers);
    }

    // 2. GET BY ID: Fetch a single provider's profile by database ID
    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        Provider provider = providerService.getProviderById(id);
        return ResponseEntity.ok(provider);
    }

    // 3. POST: Create/Submit a new provider profile (Test this in EchoAPI!)
    @PostMapping
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        Provider createdProvider = providerService.createProvider(provider);
        return new ResponseEntity<>(createdProvider, HttpStatus.CREATED);
    }

    // 4. PUT: Update an existing provider profile
    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable Long id, @RequestBody Provider providerDetails) {
        Provider updatedProvider = providerService.updateProvider(id, providerDetails);
        return ResponseEntity.ok(updatedProvider);
    }

    // 5. DELETE: Remove a provider profile
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id) {
        providerService.deleteProvider(id);
        return ResponseEntity.noContent().build();
    }
}
