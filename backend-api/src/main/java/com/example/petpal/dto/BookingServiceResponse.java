package com.example.petpal.dto;


import com.example.petpal.entity.ServiceBooking;

import java.time.LocalDateTime;
import java.math.BigDecimal;

public record BookingServiceResponse(
        Long id,
        String status,
        Long customerId,
        String customerName,
        Long petId,
        String petName,
        Long serviceId,
        String serviceName,
        BigDecimal servicePrice,
        Long providerId,
        String providerName,
        Long timeslotId,
        LocalDateTime startTime,
        LocalDateTime endTime
    ) {

    public static BookingServiceResponse from(ServiceBooking booking) {
        return new BookingServiceResponse(booking.getId(),
                booking.getStatus(), 
                booking.getCustomer().getId(),
                booking.getCustomer().getName(), 
                booking.getPet().getId(), booking.getPet().getName(),
                booking.getServiceEntity().getId(),
                booking.getServiceEntity().getTitle(), booking.getServiceEntity().getPrice(),
                booking.getServiceEntity().getProvider().getId(),
                booking.getServiceEntity().getProvider().getName(),
                booking.getTimeslot().getId(),
                booking.getTimeslot().getStartTime(), booking.getTimeslot().getEndTime());
    }
}