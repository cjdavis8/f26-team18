package com.example.petpal.service;

import com.example.petpal.model.Provider;
import com.example.petpal.repository.ProviderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    // Constructor-based dependency injection
    public ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    // Get all providers
    public List<Provider> getAllProviders() {
        return providerRepository.findAll();
    }

    // Get a provider by their primary database ID
    public Provider getProviderById(Long id) {
        return providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
    }

    // Get a provider by their linked user ID
    public Optional<Provider> getProviderByUserId(Long userId) {
        return providerRepository.findByUserId(userId);
    }

    // Create a new provider profile
    @Transactional
public Provider createProvider(Provider provider) {
    if (providerRepository.existsByEmail(provider.getEmail())) {
        throw new RuntimeException("A provider with this email already exists: " + provider.getEmail());
    }
    
    if (provider.getUserId() == null) {
        provider.setUserId(System.currentTimeMillis());
    }
    return providerRepository.save(provider);
}

    // Updating an existing user profile
    @Transactional
    public Provider updateProvider(Long id, Provider providerDetails) {
        Provider existingProvider = getProviderById(id);

        // Update fields if provided
        existingProvider.setFirstName(providerDetails.getFirstName());
        existingProvider.setLastName(providerDetails.getLastName());
        existingProvider.setBusinessName(providerDetails.getBusinessName());
        existingProvider.setPhoneNumber(providerDetails.getPhoneNumber());
        existingProvider.setAboutMe(providerDetails.getAboutMe());
        existingProvider.setLocation(providerDetails.getLocation());
        existingProvider.setHistory(providerDetails.getHistory());
        existingProvider.setPfpImageUrl(providerDetails.getPfpImageUrl());
        existingProvider.setSpecialties(providerDetails.getSpecialties());
        existingProvider.setServicesOffered(providerDetails.getServicesOffered());
        existingProvider.setAvailability(providerDetails.getAvailability());
        existingProvider.setServicePrices(providerDetails.getServicePrices());

        if (providerDetails.getPassword() != null && !providerDetails.getPassword().trim().isEmpty()) {
            existingProvider.setPassword(providerDetails.getPassword());
        }

        return providerRepository.save(existingProvider);
    }

    // Delete a provider profile
    @Transactional
    public void deleteProvider(Long id) {
        Provider provider = getProviderById(id);
        providerRepository.delete(provider);
    }
}
