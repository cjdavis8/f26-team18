package com.example.petpal.service;

import com.example.petpal.model.Provider;
import com.example.petpal.repository.ProviderRepository;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProviderService {

    private final ProviderRepository providerRepository;

    ProviderService(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    public Provider saveProvider(Provider provider) {
        return providerRepository.save(provider);
    }

    public Provider updateProvider(Long id, Provider providerDetails) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
        provider.setName(providerDetails.getName());
        provider.setEmail(providerDetails.getEmail());
        provider.setCategory(providerDetails.getCategory());
        return providerRepository.save(provider);
    }

    public Map<String, Object> getCustomerStatistics(Long id) {
        Provider provider = providerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
        
        Map<String, Object> stats = new HashMap<>();
        stats.put("providerId", provider.getId());
        stats.put("totalCustomers", 142); 
        stats.put("activeBookings", 12);
        stats.put("averageRating", 4.8);
        return stats;
    }

    public Provider getProviderById(Long id) {
    return providerRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Provider not found with id: " + id));
}
}
