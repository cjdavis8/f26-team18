package com.example.petpal.dto;


import com.example.petpal.entity.ServiceBooking;

import java.time.LocalDateTime;

public record BookingServiceResponse(
        Long id,
        Long customerId,
        String customerName,
        Long serviceId,
        String serviceName,
        Long providerId,
        String providerName
    ) {

    public static BookingServiceResponse from(ServiceBooking booking) {
        return new BookingServiceResponse(booking.getId(), 
                booking.getCustomer().getId(),
                booking.getCustomer().getName(), booking.getServiceEntity().getId(),
                booking.getServiceEntity().getTitle(), booking.getServiceEntity().getProvider().getId(),
                booking.getServiceEntity().getProvider().getName());
    }
}