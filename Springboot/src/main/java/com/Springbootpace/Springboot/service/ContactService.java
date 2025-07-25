package com.Springbootpace.Springboot.service;

import com.Springbootpace.Springboot.entity.ContactMessage;
import com.Springbootpace.Springboot.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService{

    @Autowired
    private ContactRepository contactRepository;

    public ContactMessage saveMessage(ContactMessage message) {
        return contactRepository.save(message);
    }

    public List<ContactMessage> getAllMessages() {
        return contactRepository.findAll();
    }
}
