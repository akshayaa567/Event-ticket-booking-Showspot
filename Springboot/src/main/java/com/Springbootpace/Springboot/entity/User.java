package com.Springbootpace.Springboot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = "email"),
    @UniqueConstraint(columnNames = "phone_number")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First name is required")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Column(name = "last_name")
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(nullable = false)
    private String email;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    @Column(nullable = false)
    private String password;

    @Column(name = "terms_accepted")
    private boolean termsAccepted;

    @Column(name = "role")
    private String role = "USER"; // default role

    // Constructors
    public User() {}

    public User(String firstName, String lastName, String email, String phoneNumber, String password, boolean termsAccepted) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.termsAccepted = termsAccepted;
    }

    // Getters and Setters
    // (You can generate these using your IDE or Lombok if configured)
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() { return phoneNumber; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public boolean isTermsAccepted() { return termsAccepted; }

    public void setTermsAccepted(boolean termsAccepted) { this.termsAccepted = termsAccepted; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}
