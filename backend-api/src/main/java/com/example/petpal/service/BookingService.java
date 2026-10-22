package com.example.petpal.service;

import com.example.petpal.dto.*;
import com.example.petpal.entity.*;
import com.example.petpal.model.*;

import com.example.petpal.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class BookingService {
    private final ServiceBookingRepository bookingRepository;
    private final CustomerRepository customerRepository;
    private final ServiceRepository serviceRepository;
    private final TimeslotRepository timeslotRepository;

    public BookingService(
            ServiceBookingRepository bookingRepository,
            CustomerRepository customerRepository,
            ServiceRepository serviceRepository,
            TimeslotRepository timeslotRepository) {
        this.bookingRepository = bookingRepository;
        this.customerRepository = customerRepository;
        this.serviceRepository = serviceRepository;
        this.timeslotRepository = timeslotRepository;
    }

    public BookingServiceResponse book(Long customerId, BookingRequest request) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new NotFoundException("Customer " + customerId + " was not found."));
        ServiceEntity serviceEntity = serviceRepository.findById(request.trainingServiceId())
                .orElseThrow(() -> new NotFoundException(
                        "Training service " + request.trainingServiceId() + " was not found."));


        ServiceBooking booking = new ServiceBooking();
        booking.setCustomer(customer);
        booking.setServiceEntity(serviceEntity);
        booking.setStatus("BOOKED");
        return BookingServiceResponse.from(bookingRepository.save(booking));
    }

    @Transactional(readOnly = true)
    public List<BookingServiceResponse> listForCustomer(Long customerId) {
        if (!customerRepository.existsById(customerId)) {
            throw new NotFoundException("Customer " + customerId + " was not found.");
        }
        return bookingRepository.findAllByCustomerIdOrderByIdDesc(customerId)
                .stream().map(BookingServiceResponse::from).toList();
    }

    @Transactional(readOnly = true)
    public List<BookingServiceResponse> listForTrainer(Long trainerId) {
        return bookingRepository.findAllByService_Provider_IdOrderByIdDesc(trainerId)
                .stream().map(BookingServiceResponse::from).toList();
    }

    public BookingServiceResponse cancel(Long customerId, Long bookingId) {
        ServiceBooking booking = lockbooking(bookingId);
        ensureCustomerOwns(booking, customerId);
        ensureBooked(booking);
        booking.setStatus("CANCELLED");
        Timeslot timeslot = lockTimeslot(booking.getTimeslot().getId());
        timeslot.setIsAvailable(true);
        booking.setTimeslot(null);
        return BookingServiceResponse.from(bookingRepository.save(booking));
    }

    public BookingServiceResponse reschedule(
            Long customerId, Long bookingId, RescheduleBookingRequest request) {
        ServiceBooking booking = lockbooking(bookingId);
        ensureCustomerOwns(booking, customerId);
        ensureBooked(booking);
        return BookingServiceResponse.from(bookingRepository.save(booking));
    }

    public BookingServiceResponse markCompleted(Long trainerId, Long bookingId) {
        ServiceBooking booking = lockbooking(bookingId);
        if (!booking.getServiceEntity().getProvider().getId().equals(trainerId)) {
            throw new NotFoundException("Training booking " + bookingId + " was not found for trainer "
                    + trainerId + ".");
        }
        ensureBooked(booking);
        booking.setStatus("COMPLETED");
        return BookingServiceResponse.from(bookingRepository.save(booking));
    }

    public BookingServiceResponse updateNotes(
            Long customerId, Long bookingId) {
        ServiceBooking booking = lockbooking(bookingId);
        ensureCustomerOwns(booking, customerId);
        if ("CANCELLED".equalsIgnoreCase(booking.getStatus())) {
            throw new ConflictException("Notes cannot be updated for a cancelled booking.");
        }
        return BookingServiceResponse.from(bookingRepository.save(booking));
    }

    private void ensureBookable(Timeslot timeslot) {
        if (!Boolean.TRUE.equals(timeslot.getIsAvailable())) {
            throw new ConflictException("The selected timeslot is no longer available.");
        }
        if (timeslot.getServiceBooking() != null) {
            throw new ConflictException("The selected timeslot already has a booked booking.");
        }
        if (!timeslot.getStartTime().isAfter(LocalDateTime.now())) {
            throw new ConflictException("The selected timeslot is in the past.");
        }
    }

    private void ensureBooked(ServiceBooking booking) {
        if (!"BOOKED".equals(booking.getStatus().toUpperCase(Locale.ROOT))) {
            throw new ConflictException("Only booked bookings can be changed.");
        }
    }

    private void ensureCustomerOwns(ServiceBooking booking, Long customerId) {
        if (!booking.getCustomer().getId().equals(customerId)) {
            throw new NotFoundException("Training booking " + booking.getId() + " was not found for customer "
                    + customerId + ".");
        }
    }

    private Timeslot lockTimeslot(Long timeslotId) {
        return timeslotRepository.findByIdForUpdate(timeslotId)
                .orElseThrow(() -> new NotFoundException("Timeslot " + timeslotId + " was not found."));
    }

    private ServiceBooking lockbooking(Long bookingId) {
        return bookingRepository.findByIdForUpdate(bookingId)
                .orElseThrow(() -> new NotFoundException(
                        "Training booking " + bookingId + " was not found."));
    }
}