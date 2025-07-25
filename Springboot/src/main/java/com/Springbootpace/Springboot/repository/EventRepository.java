package com.Springbootpace.Springboot.repository;

import com.Springbootpace.Springboot.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    // No need to write any code here — JPA gives basic CRUD for free
}
