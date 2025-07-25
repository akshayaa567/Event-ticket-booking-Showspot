package com.Springbootpace.Springboot.controller;

import com.Springbootpace.Springboot.entity.Event;
import com.Springbootpace.Springboot.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events") // ✅ Keeping as /api/events, as you said
@CrossOrigin(origins = "*")
public class EventController {

    @Autowired
    private EventService eventService;

    // ✅ CREATE EVENT
    @PostMapping("/create")
    public ResponseEntity<Event> createEvent(@RequestBody Event event) {
        return ResponseEntity.ok(eventService.saveEvent(event));
    }

    // ✅ READ ALL EVENTS
    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents() {
        return ResponseEntity.ok(eventService.getAllEvents());
    }

    // ✅ READ EVENT BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Event> getEventById(@PathVariable Long id) {
        Optional<Event> event = eventService.getEventById(id);
        return event.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
    }

    // ✅ UPDATE EVENT
    @PutMapping("/update/{id}")
    public ResponseEntity<Event> updateEvent(@PathVariable Long id, @RequestBody Event updatedEvent) {
        Optional<Event> existingEvent = eventService.getEventById(id);
        if (existingEvent.isPresent()) {
            Event event = existingEvent.get();
            event.setTitle(updatedEvent.getTitle());
            event.setType(updatedEvent.getType());
            event.setDescription(updatedEvent.getDescription());
            event.setLocation(updatedEvent.getLocation());
            event.setPrice(updatedEvent.getPrice());
            return ResponseEntity.ok(eventService.saveEvent(event));
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // ✅ DELETE EVENT
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}
