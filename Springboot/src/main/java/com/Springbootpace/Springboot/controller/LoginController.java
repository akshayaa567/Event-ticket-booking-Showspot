package com.Springbootpace.Springboot.controller;

import com.Springbootpace.Springboot.entity.LoginRequest;
import com.Springbootpace.Springboot.entity.User;
import com.Springbootpace.Springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // ✅ USER LOGIN
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        User user = loginService.authenticateUser(loginRequest);

        if (user != null) {
            user.setPassword(null); // Remove sensitive info
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }

    // ✅ ADMIN LOGIN
    @PostMapping("/admin-login")
    public ResponseEntity<?> adminLogin(@RequestBody LoginRequest loginRequest) {
        User admin = loginService.authenticateAdmin(loginRequest);

        if (admin != null) {
            admin.setPassword(null); // Remove sensitive info
            return ResponseEntity.ok(admin);
        } else {
            return ResponseEntity.status(401).body("Invalid admin credentials");
        }
    }
}
