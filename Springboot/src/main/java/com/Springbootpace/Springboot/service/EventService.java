package com.Springbootpace.Springboot.service;

import com.Springbootpace.Springboot.entity.Event;
import com.Springbootpace.Springboot.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    // Create or Update Event
    public Event saveEvent(Event event) {
        return eventRepository.save(event);
    }

    // Get all events
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    // Get event by ID
    public Optional<Event> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    // Delete event by ID
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
