package com.example.demo.service.impl;

import com.example.demo.model.EmployeeProfile;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.service.EmployeeProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileService {

    private final EmployeeProfileRepository repository;

    public EmployeeProfileServiceImpl(EmployeeProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public EmployeeProfile create(EmployeeProfile employeeProfile) {
        return repository.save(employeeProfile);
    }

    @Override
    public EmployeeProfile update(Long id, EmployeeProfile updatedProfile) {
        EmployeeProfile existing = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        existing.setFullName(updatedProfile.getFullName());
        existing.setEmail(updatedProfile.getEmail());
        existing.setTeamName(updatedProfile.getTeamName());
        existing.setRole(updatedProfile.getRole());
        existing.setActive(updatedProfile.getActive());

        return repository.save(existing);
    }

    @Override
    public void deactivate(Long id) {
        EmployeeProfile employee = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));

        employee.setActive(false);
        repository.save(employee);
    }

    @Override
    public EmployeeProfile getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

    @Override
    public List<EmployeeProfile> getByTeam(String teamName) {
        return repository.findByTeamNameAndActiveTrue(teamName);
    }

    @Override
    public List<EmployeeProfile> getAll() {
        return repository.findAll();
    }
}
