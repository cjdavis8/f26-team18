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

    List<ServiceBooking> findAllByTrainingService_Trainer_IdOrderByIdDesc(Long trainerId);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select trainingSession from TrainingSession trainingSession "
            + "where trainingSession.id = :id")
    Optional<ServiceBooking> findByIdForUpdate(@Param("id") Long id);
}