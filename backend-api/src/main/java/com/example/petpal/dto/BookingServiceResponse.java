package com.example.petpal.dto;


import com.example.petpal.entity.ServiceBooking;

import java.time.LocalDateTime;
import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

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
                booking.getTimeslot() == null ? null : booking.getTimeslot().getId(),
                booking.getTimeslot() == null ? null : booking.getTimeslot().getStartTime(), 
                booking.getTimeslot() == null ? null : booking.getTimeslot().getEndTime());
    }

    private static final DateTimeFormatter DISPLAY_DATE_TIME =
        DateTimeFormatter.ofPattern("MMM d, yyyy h:mm a");

    public String startTimeDisplay() {
        return startTime == null ? "Not scheduled" : startTime.format(DISPLAY_DATE_TIME);
    }

    public String endTimeDisplay() {
        return endTime == null ? "Not scheduled" : endTime.format(DISPLAY_DATE_TIME);
}
}