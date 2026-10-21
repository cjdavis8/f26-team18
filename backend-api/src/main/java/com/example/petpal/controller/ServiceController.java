package com.example.petpal.controller;

import com.example.petpal.model.ServiceEntity;
import com.example.petpal.service.ServiceManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/services")
public class ServiceController {

    private final ServiceManagementService serviceManagementService;

    ServiceController(ServiceManagementService serviceManagementService) {
        this.serviceManagementService = serviceManagementService;
    }

    @PostMapping
    public ResponseEntity<ServiceEntity> createService(@RequestBody ServiceEntity serviceEntity) {
        return ResponseEntity.ok(serviceManagementService.createService(serviceEntity));
    }
}