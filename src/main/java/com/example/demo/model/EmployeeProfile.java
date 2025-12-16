package com.example.demo.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class EmployeeProfile {
    @Id
   private long id;
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private String employeedId;
   private String fullName;
@Email
@Column(unique = true)
    private String email;
    private String teamName;
    private String role;
    private boolean active;
    private LocalDateTime createdAt;
}

