package com.example.petpal.dto;

import com.example.petpal.entity.Customer;
import com.example.petpal.entity.Pet;

import java.util.Optional;

public record PetResponse (
        Long id,
        Customer customer,
        String name,
        String breed,
        int weight,
        int age) {

    public static PetResponse from(Pet pet) {
        return new PetResponse(pet.getId(), pet.getCustomer(), pet.getName(),
                pet.getBreed(), pet.getWeight(), pet.getAge());
    }
}
