package com.Springbootpace.Springboot.repository;

import com.Springbootpace.Springboot.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactMessage, Long> {
}
