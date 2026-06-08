package com.HotelBooking.Anyone20.Anyone.repo;

import com.HotelBooking.Anyone20.Anyone.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
