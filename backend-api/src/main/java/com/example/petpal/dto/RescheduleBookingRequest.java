package com.example.petpal.dto;

import jakarta.validation.constraints.NotNull;

public record RescheduleBookingRequest(@NotNull Long timeslotId) {
}