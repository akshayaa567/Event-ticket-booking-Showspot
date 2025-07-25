package com.Springbootpace.Springboot.controller;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {

    @Value("${razorpay.key_id}")
    private String razorpayKeyId;

    @Value("${razorpay.key_secret}")
    private String razorpayKeySecret;

    @PostMapping("/createOrder")
    public ResponseEntity<String> createOrder(@RequestParam int amount) {
        try {
            RazorpayClient client = new RazorpayClient(razorpayKeyId, razorpayKeySecret);

            JSONObject options = new JSONObject();
            options.put("amount", amount * 100); // amount in paise
            options.put("currency", "INR");
            options.put("receipt", UUID.randomUUID().toString());

            Order order = client.orders.create(options);

            return ResponseEntity.ok(order.toString());

        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error: " + e.getMessage());
        }
    }
}
