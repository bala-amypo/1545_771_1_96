package com.example.demo.service;

import com.example.demo.entity.EmployeeProfile;

import java.util.List;

public interface EmployeeProfileService {

    EmployeeProfile create(EmployeeProfile employeeProfile);

    EmployeeProfile update(Long id, EmployeeProfile employeeProfile);

    void deactivate(Long id);

    EmployeeProfile getById(Long id);

    List<EmployeeProfile> getByTeam(String teamName);

    List<EmployeeProfile> getAll();
}
