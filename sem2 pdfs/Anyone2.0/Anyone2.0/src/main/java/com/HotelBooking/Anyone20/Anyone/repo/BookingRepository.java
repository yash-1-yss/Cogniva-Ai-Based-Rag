package com.HotelBooking.Anyone20.Anyone.repo;

import com.HotelBooking.Anyone20.Anyone.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking,Long> {
    Optional<Booking> findByBookingConfirmationCode(String confirmationCode);

}
