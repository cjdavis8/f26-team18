package com.example.petpal.service;

import com.example.petpal.entity.Customer;
import com.example.petpal.repository.CustomerRepository;
import com.example.petpal.dto.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

@Service
@Transactional
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public CustomerResponse register(CustomerRegistrationRequest request) {
        ensureEmailAvailable(request.email());
        validatePasswordLength(request.password());
        Customer customer = new Customer();
        customer.setName(request.name().trim());
        customer.setEmail(request.email().trim().toLowerCase(Locale.ROOT));
        customer.setPassword(request.password());
        return CustomerResponse.from(customerRepository.save(customer));
    }

    @Transactional(readOnly = true)
    public CustomerResponse getProfile(Long customerId) {
        return CustomerResponse.from(findCustomer(customerId));
    }

    public CustomerResponse updateProfile(Long customerId, CustomerUpdateRequest request) {
        Customer customer = findCustomer(customerId);
        if (!customer.getEmail().equalsIgnoreCase(request.email())
                && customerRepository.existsByEmailIgnoreCase(request.email())) {
            throw new ConflictException("An account with that email already exists.");
        }
        customer.setName(request.name().trim());
        customer.setEmail(request.email().trim().toLowerCase(Locale.ROOT));
        return CustomerResponse.from(customerRepository.save(customer));
    }

    private Customer findCustomer(Long customerId) {
        return customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("Customer " + customerId + " was not found."));
    }

    private void ensureEmailAvailable(String email) {
        if (customerRepository.existsByEmailIgnoreCase(email)) {
            throw new ConflictException("An account with that email already exists.");
        }
    }

    private void validatePasswordLength(String password) {
        if (password.getBytes(StandardCharsets.UTF_8).length > 72) {
            throw new BadRequestException("Password must be no more than 72 UTF-8 bytes.");
        }
    }
}