package com.example.petpal.dto;

import com.example.petpal.entity.Customer;
import com.example.petpal.entity.Pet;

import java.util.List;

public record CustomerResponse(
        Long id,
        String name,
        String email,
        List<Pet> pets) {

    public static CustomerResponse from(Customer customer) {
        return new CustomerResponse(customer.getId(), customer.getName(), customer.getEmail(),
                customer.getPets());
    }


}