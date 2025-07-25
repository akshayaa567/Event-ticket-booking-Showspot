package com.Springbootpace.Springboot.service;

import com.Springbootpace.Springboot.entity.User;
import com.Springbootpace.Springboot.dto.SignupRequest;
import com.Springbootpace.Springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String registerUser(SignupRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            return "Email is already registered";
        }

        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            return "Phone number is already registered";
        }

        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return "Passwords do not match";
        }

        if (!request.isTermsAccepted()) {
            return "You must accept the terms and conditions";
        }

        User user = new User();
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setEmail(request.getEmail());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setPassword(passwordEncoder.encode(request.getPassword())); // hashed password
        user.setRole("ROLE_USER");

        userRepository.save(user);
        return "User registered successfully";
    }
}
