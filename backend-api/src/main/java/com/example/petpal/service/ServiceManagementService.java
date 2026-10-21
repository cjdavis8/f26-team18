package com.example.petpal.service;

import com.example.petpal.model.ServiceEntity;
import com.example.petpal.repository.ServiceRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceManagementService {

    private final ServiceRepository serviceRepository;

    ServiceManagementService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    public ServiceEntity createService(ServiceEntity serviceEntity) {
        return serviceRepository.save(serviceEntity);
    }
}
