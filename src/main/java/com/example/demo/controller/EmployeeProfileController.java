package com.example.demo.controller;

import com.example.demo.model.EmployeeProfile;
import com.example.demo.service.EmployeeProfileService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name = "Employee Profile API")
public class EmployeeProfileController {

    private final EmployeeProfileService service;

    public EmployeeProfileController(EmployeeProfileService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeProfile createEmployee(@RequestBody EmployeeProfile employeeProfile) {
        return service.create(employeeProfile);
    }

   
    @PutMapping("/{id}")
    public EmployeeProfile updateEmployee(
            @PathVariable Long id,
            @RequestBody EmployeeProfile employeeProfile) {
        return service.update(id, employeeProfile);
    }

   
    @GetMapping("/{id}")
    public EmployeeProfile getEmployee(@PathVariable Long id) {
        return service.getById(id);
    }

    
    @GetMapping("/team/{teamName}")
    public List<EmployeeProfile> getEmployeesByTeam(@PathVariable String teamName) {
        return service.getByTeam(teamName);
    }
}