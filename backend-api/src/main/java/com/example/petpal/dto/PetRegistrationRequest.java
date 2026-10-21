package com.example.petpal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PetRegistrationRequest (
    @NotNull Long customerId,
    @NotBlank @Size(max = 100) String name,
    @NotBlank @Email @Size(max = 254) String breed,
    @NotBlank @Size(max = 5) int age,
    @NotBlank @Size(max = 5) int weight
) {
    
}
