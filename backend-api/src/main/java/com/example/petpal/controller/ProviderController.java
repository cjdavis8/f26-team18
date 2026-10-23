package com.example.petpal.controller;

import com.example.petpal.model.Provider;
import com.example.petpal.service.ProviderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/providers")
public class ProviderController {

    private final ProviderService providerService;

    ProviderController(ProviderService providerService) {
        this.providerService = providerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provider> getProviderById(@PathVariable Long id) {
        return ResponseEntity.ok(providerService.getProviderById(id));
    }

    @PostMapping
    public ResponseEntity<Provider> createProvider(@RequestBody Provider provider) {
        return ResponseEntity.ok(providerService.saveProvider(provider));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provider> updateProvider(@PathVariable Long id, @RequestBody Provider provider) {
        return ResponseEntity.ok(providerService.updateProvider(id, provider));
    }

    @GetMapping("/{id}/statistics")
    public ResponseEntity<Map<String, Object>> getCustomerStatistics(@PathVariable Long id) {
        return ResponseEntity.ok(providerService.getCustomerStatistics(id));
    }
}
