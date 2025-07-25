package com.Springbootpace.Springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String type; // Movie, Concert, etc.

    private String description;

    private String location;

    private double price;

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }

    public void setLocation(String location) { this.location = location; }


    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
