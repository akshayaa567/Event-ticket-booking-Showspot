package com.Springbootpace.Springboot.service;

import com.Springbootpace.Springboot.entity.User;
import com.Springbootpace.Springboot.entity.LoginRequest;
import com.Springbootpace.Springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ✅ General User Login
    public User authenticateUser(LoginRequest loginRequest) {
        return authenticateByRole(loginRequest, "USER");
    }

    // ✅ Admin Login
    public User authenticateAdmin(LoginRequest loginRequest) {
        return authenticateByRole(loginRequest, "ADMIN");
    }

    // ✅ Shared Auth Logic
    public User authenticateByRole(LoginRequest loginRequest, String role) {
        Optional<User> userOptional = userRepository.findByEmail(loginRequest.getEmail());

        System.out.println("Login attempt:");
        System.out.println("Provided Email: " + loginRequest.getEmail());
        System.out.println("Provided Password: " + loginRequest.getPassword());
        System.out.println("Expected Role: " + role);

        if (userOptional.isPresent()) {
            User user = userOptional.get();

            System.out.println("User found in DB:");
            System.out.println("DB Email: " + user.getEmail());
            System.out.println("DB Password: " + user.getPassword());
            System.out.println("DB Role: " + user.getRole());

            boolean passwordMatch = loginRequest.getPassword().equals(user.getPassword());

            // ✅ Normalize the role by removing "ROLE_" prefix if it exists
            String dbRole = user.getRole().toUpperCase().replace("ROLE_", "");
            boolean roleMatch = dbRole.equalsIgnoreCase(role);

            if (passwordMatch && roleMatch) {
                System.out.println("✅ Login successful");
                return user;
            } else {
                if (!passwordMatch) {
                    System.out.println("❌ Password mismatch");
                }
                if (!roleMatch) {
                    System.out.println("❌ Role mismatch: expected '" + role + "', but found '" + user.getRole() + "'");
                }
            }
        } else {
            System.out.println("❌ No user found with email: " + loginRequest.getEmail());
        }

        return null;
    }
}
