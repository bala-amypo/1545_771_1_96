Impl
package com.example.demo.service.impl;

import com.example.demo.dto.CapacityAnalysisResultDto;
import com.example.demo.exception.BadRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.CapacityAlert;
import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.repository.CapacityAlertRepository;
import com.example.demo.repository.EmployeeProfileRepository;
import com.example.demo.repository.LeaveRequestRepository;
import com.example.demo.repository.TeamCapacityConfigRepository;
import com.example.demo.service.CapacityAnalysisService;
import com.example.demo.util.DateRangeUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CapacityAnalysisServiceImpl implements CapacityAnalysisService {

    private final TeamCapacityConfigRepository capacityRepo;
    private final EmployeeProfileRepository employeeRepo;
    private final LeaveRequestRepository leaveRepo;
    private final CapacityAlertRepository alertRepo;

    public CapacityAnalysisServiceImpl(
            TeamCapacityConfigRepository capacityRepo,
            EmployeeProfileRepository employeeRepo,
            LeaveRequestRepository leaveRepo,
            CapacityAlertRepository alertRepo
    ) {
        this.capacityRepo = capacityRepo;
        this.employeeRepo = employeeRepo;
        this.leaveRepo = leaveRepo;
        this.alertRepo = alertRepo;
    }

    @Override
    public CapacityAnalysisResultDto analyzeTeamCapacity(
            String teamName,
            LocalDate start,
            LocalDate end
    ) {

        if (!DateRangeUtil.daysBetween(start, end)) {
            throw new BadRequestException("Start date is invalid or future");
        }

        TeamCapacityConfig config = capacityRepo.findByTeamName(teamName)
                .orElseThrow(() -> new ResourceNotFoundException("Capacity config not found"));

        int totalHeadcount = config.getTotalHeadcount();
        int minCapacityPercent = config.getMinCapacityPercent();

        List<?> activeEmployees =
                employeeRepo.findByTeamNameAndActiveTrue(teamName);

        Map<LocalDate, Double> capacityMap = new HashMap<>();
        boolean risky = false;

        LocalDate current = start;
        while (!current.isAfter(end)) {

            int onLeaveCount =
                    leaveRepo.findApprovedOverlappingForTeam(teamName, current, current).size();

            double availablePercent =
                    ((double) (totalHeadcount - onLeaveCount) / totalHeadcount) * 100;

            capacityMap.put(current, availablePercent);

            if (availablePercent < minCapacityPercent) {
                risky = true;

                String severity =
                        availablePercent < minCapacityPercent / 2 ? "HIGH" : "MEDIUM";

                CapacityAlert alert = new CapacityAlert(
                        teamName,
                        current,
                        severity,
                        "Team capacity below threshold"
                );

                alertRepo.save(alert);
            }

            current = current.plusDays(1);
        }

        CapacityAnalysisResultDto result = new CapacityAnalysisResultDto();
        result.setRisky(risky);
        result.setCapacityByDate(capacityMap);

        return result;
    }
}