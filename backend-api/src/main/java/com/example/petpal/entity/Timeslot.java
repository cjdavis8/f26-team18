package com.example.petpal.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;

import com.example.petpal.model.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "timeslots")
public class Timeslot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime startTime;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime endTime;

    @NotNull
    @Column(nullable = false)
    private Boolean isAvailable;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trainer_id", nullable = false)
    private Provider provider;

    @OneToOne(mappedBy = "timeslot", fetch = FetchType.LAZY)
    @JsonIgnore
    private ServiceBooking booking;

    public Timeslot() {
    }

    @AssertTrue(message = "endTime must be after startTime")
    public boolean isTimeRangeValid() {
        return startTime == null || endTime == null || endTime.isAfter(startTime);
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    @JsonIgnore
    public ServiceBooking getBookedService() {
        return booking != null && "BOOKED".equalsIgnoreCase(booking.getStatus())
                ? booking
                : null;
    }

    @JsonIgnore
    public ServiceBooking getServiceBooking() {
        return booking;
    }

    public void setServiceBooking(ServiceBooking booking) {
        this.booking = booking;
    }
}