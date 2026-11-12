package com.example.petpal.service;

import com.example.petpal.entity.*;
import com.example.petpal.repository.PetRepository;
import com.example.petpal.repository.CustomerRepository;
import com.example.petpal.dto.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class PetService {
    private final PetRepository petRepository;
    private final CustomerRepository customerRepository;

    public PetService(PetRepository petRepository,
        CustomerRepository customerRepository
    ) {
        this.petRepository = petRepository;
        this.customerRepository = customerRepository;
    }

    public PetResponse register(Customer customer, PetRegistrationRequest request) {
        Pet pet = new Pet();
        pet.setCustomer(customer);
        pet.setName(request.name().trim());
        pet.setBreed(request.breed().trim());
        pet.setAge(request.age());
        pet.setWeight(request.weight());
        return PetResponse.from(petRepository.save(pet));
    }

    @Transactional(readOnly = true)
    public PetResponse getProfile(Long petId) {
        return PetResponse.from(findPet(petId));
    }

    public PetResponse updateProfile(Long petId, PetUpdateRequest request) {
        Pet pet = findPet(petId);
        pet.setName(request.name().trim());
        pet.setBreed(request.breed().trim());
        pet.setAge(request.age());
        pet.setWeight(request.weight());
        return PetResponse.from(petRepository.save(pet));
    }

    private Pet findPet(Long petId) {
        return petRepository.findById(petId)
                .orElseThrow(() -> new NotFoundException("Pet " + petId + " was not found."));
    }

}