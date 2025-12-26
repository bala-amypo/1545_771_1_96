// package com.example.demo.model;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;
// import java.util.HashSet;
// import java.util.Set;

// @Entity
// @Table(
//         name = "employee_profiles",
//         uniqueConstraints = {
//                 @UniqueConstraint(columnNames = "employeeId"),
//                 @UniqueConstraint(columnNames = "email")
//         }
// )
// public class EmployeeProfile {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String employeeId;  // Business identifier

//     @Column(nullable = false)
//     private String fullName;

//     @Column(nullable = false)
//     private String email;

//     @Column(nullable = false)
//     private String teamName;

//     @Column(nullable = false)
//     private String role;

//     @Column(nullable = false)
//     private Boolean active = true;

//     @Column(nullable = false)
//     private LocalDateTime createdAt;

    
//     @ManyToMany
//     @JoinTable(
//             name = "employee_colleagues",
//             joinColumns = @JoinColumn(name = "employee_id"),
//             inverseJoinColumns = @JoinColumn(name = "colleague_id")
//     )
//     private Set<EmployeeProfile> colleagues = new HashSet<>();

   
//     @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//     private Set<com.example.demo.model.LeaveRequest> leaveRequests = new HashSet<>();

    

//     public EmployeeProfile() {
//         this.createdAt = LocalDateTime.now();
//     }

//     public EmployeeProfile(String employeeId, String fullName, String email,
//                            String teamName, String role) {
//         this.employeeId = employeeId;
//         this.fullName = fullName;
//         this.email = email;
//         this.teamName = teamName;
//         this.role = role;
//         this.active = true;
//         this.createdAt = LocalDateTime.now();
//     }

    
  

//     public Long getId() {
//         return id;
//     }

//     public String getEmployeeId() {
//         return employeeId;
//     }

//     public void setEmployeeId(String employeeId) {
//         this.employeeId = employeeId;
//     }

//     public String getFullName() {
//         return fullName;
//     }

//     public void setFullName(String fullName) {
//         this.fullName = fullName;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getTeamName() {
//         return teamName;
//     }

//     public void setTeamName(String teamName) {
//         this.teamName = teamName;
//     }

//     public String getRole() {
//         return role;
//     }

//     public void setRole(String role) {
//         this.role = role;
//     }

//     public Boolean getActive() {
//         return active;
//     }

//     public void setActive(Boolean active) {
//         this.active = active;
//     }

//     public LocalDateTime getCreatedAt() {
//         return createdAt;
//     }

//     public Set<EmployeeProfile> getColleagues() {
//         return colleagues;
//     }

//     public void setColleagues(Set<EmployeeProfile> colleagues) {
//         this.colleagues = colleagues;
//     }

//     public Set<LeaveRequest> getLeaveRequests() {
//         return leaveRequests;
//     }

//     public void setLeaveRequests(Set<LeaveRequest> leaveRequests) {
//         this.leaveRequests = leaveRequests;
//     }
// }

package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class EmployeeProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String employeeId;
    private String fullName;
    @Column(unique = true, nullable = false)
    private String email;
    private String teamName;
    private String role;
    private Boolean active = true;
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
        name = "employee_colleagues",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "colleague_id")
    )
    private Set<EmployeeProfile> colleagues = new HashSet<>();

    public EmployeeProfile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTeamName() { return teamName; }
    public void setTeamName(String teamName) { this.teamName = teamName; }
    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }
    public void setActive(Boolean active) { this.active = active; }

    // Test requires this naming specifically
    public Boolean isActive() { return active; }
    
    public Set<EmployeeProfile> getColleagues() { return colleagues; }
    public void setColleagues(Set<EmployeeProfile> colleagues) { this.colleagues = colleagues; }
}