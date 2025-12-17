package com.example.demo.model;

import java.time.LocalDateTime;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class EmployeeProfile {
    @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
   @Column(unique = true)
    private String employeedId;
    private String fullName;
   
   @Column(unique = true)
    private String email;
    private String teamName;
    private String role;
    private Boolean active=true;
    private LocalDateTime createdAt;



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
EmployeeProfile
service
create
update(Long id)
deactivate(Long id)
getById(Long id)
getByTeam(string teamName)
getAll()

controller
POST-create employee
PUT/{id}-update employee
GET/{id}-get employee
GET/team/{teamName}-list employees by team