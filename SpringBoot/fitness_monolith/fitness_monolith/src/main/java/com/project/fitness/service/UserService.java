package com.project.fitness.service;

import com.project.fitness.dto.RegisterRequest;
import com.project.fitness.dto.UserResponse;
import com.project.fitness.model.User;
import com.project.fitness.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    public UserResponse register(RegisterRequest registerRequest) {
        User user=User.builder()
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword())
                .firstName((registerRequest.getFirstName()))
                .lastName(registerRequest.getLastName())
                .build();
//        User user=new User(
//                null,
//                registerRequest.getEmail(),
//                registerRequest.getPassword(),
//                registerRequest.getFirstName(),
//                registerRequest.getLastName(),
//                LocalDateTime.now(),
//                LocalDateTime.now(),
//                List.of(),
//                List.of()
//        );
        User savedUser = userRepository.save(user);
        return mapToUserResponse(savedUser);
    }

    private UserResponse mapToUserResponse(User savedUser) {
        UserResponse response=new UserResponse(
                savedUser.getId(), savedUser.getEmail(), savedUser.getPassword(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getCreatedAt(),savedUser.getUpdatedAt()
                );
        return response;

    }
}
