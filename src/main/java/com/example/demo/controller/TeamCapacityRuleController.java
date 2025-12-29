

package com.example.demo.controller;

import com.example.demo.model.TeamCapacityConfig;
import com.example.demo.service.TeamCapacityRuleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/api/capacity-rules")
@SecurityRequirement(name = "bearerAuth")
public class TeamCapacityRuleController {
    private final TeamCapacityRuleService service;

    public TeamCapacityRuleController(TeamCapacityRuleService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<TeamCapacityConfig> create(@RequestBody TeamCapacityConfig config) {
        return ResponseEntity.ok(service.createRule(config));
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<TeamCapacityConfig> getByTeam(@PathVariable String teamName) {
        return ResponseEntity.ok(service.getRuleByTeam(teamName));
    }

}