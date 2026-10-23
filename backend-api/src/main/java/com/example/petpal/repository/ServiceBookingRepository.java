package com.example.petpal.repository;

import com.example.petpal.model.ServiceEntity;
import com.example.petpal.entity.*;

import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Long> {
    List<ServiceBooking> findAllByCustomerIdOrderByIdDesc(Long customerId);

    List<ServiceBooking> findAllByServiceEntity_Provider_IdOrderByIdDesc(Long providerId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select booking from ServiceBooking booking "
            + "where booking.id = :id")
    Optional<ServiceBooking> findByIdForUpdate(@Param("id") Long id);
}