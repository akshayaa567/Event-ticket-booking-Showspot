package com.Springbootpace.Springboot.controller;

import com.Springbootpace.Springboot.entity.ContactMessage;
import com.Springbootpace.Springboot.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List; // ✅ Don't forget this import

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // ✅ POST: Save message (already working)
    @PostMapping
    public ContactMessage submitMessage(@RequestBody ContactMessage contact) {
        System.out.println("💬 Received: " + contact);
        return contactService.saveMessage(contact);
    }

    // ✅ NEW: GET all messages for admin
    @GetMapping("/messages")
    public List<ContactMessage> getAllMessages() {
        return contactService.getAllMessages();
    }
}
