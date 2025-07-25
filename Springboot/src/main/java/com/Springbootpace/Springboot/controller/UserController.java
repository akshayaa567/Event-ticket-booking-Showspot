package com.Springbootpace.Springboot.controller;

import com.Springbootpace.Springboot.dto.SignupRequest;
import com.Springbootpace.Springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*") // Enable this if frontend and backend are on different ports
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest request) {
        String result = userService.registerUser(request);

        if (result.equals("User registered successfully")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.badRequest().body(result);
        }
    }
}
