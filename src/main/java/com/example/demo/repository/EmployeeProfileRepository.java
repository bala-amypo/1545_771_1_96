package com.example.demo1.repository;

import com.example.demo1.model.EmployeeProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeProfileRepository extends JpaRepository<EmployeeProfile, Long> {

    List<EmployeeProfile> findByTeamNameAndActiveTrue(String teamName);
}
