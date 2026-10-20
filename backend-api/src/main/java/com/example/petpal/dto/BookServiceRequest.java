package com.example.petpal.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record BookServiceRequest (
    @NotNull Long providerServiceId,
    @NotNull Long timeslotID,
    @NotNull Long petID,
    @Size(max = 2000) String notes
){

}
