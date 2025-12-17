package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employee_profiles")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "employee_id", nullable = false, unique = true)
    private String employeeId;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(nullable = false, unique = true)
    private String email;
    @Column(name = "team_name", nullable = false)
    private String teamName;
    @Column(nullable = false)
    private String role;
    @Column(nullable = false)
    private Boolean active = true;
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
    @ManyToMany
    @JoinTable(
        name = "employee_colleagues",
        joinColumns = @JoinColumn(name = "employee_profile_id"),
        inverseJoinColumns = @JoinColumn(name = "colleague_profile_id")
    )
    private Set<EmployeeProfile> colleagues = new HashSet<>();

    private String employeedId;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }
public EmployeeProfile()
{

}

public EmployeeProfile( String employeedId, String fullName, String email, String teamName, String role,
        Boolean active, LocalDateTime createdAt)
         {
  
    this.employeedId = employeedId;
    this.fullName = fullName;
    this.email = email;
    this.teamName = teamName;
    this.role = role;
    this.active = active;
    this.createdAt = createdAt;
}

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getEmployeedId() {
    return employeedId;
}

public void setEmployeedId(String employeedId) {
    this.employeedId = employeedId;
}

public String getFullName() {
    return fullName;
}

public void setFullName(String fullName) {
    this.fullName = fullName;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getTeamName() {
    return teamName;
}

public void setTeamName(String teamName) {
    this.teamName = teamName;
}

public String getRole() {
    return role;
}

public void setRole(String role) {
    this.role = role;
}

public Boolean getActive() {
    return active;
}

public void setActive(Boolean active) {
    this.active = active;
}

public LocalDateTime getCreatedAt() {
    return createdAt;
}

public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
}
}

