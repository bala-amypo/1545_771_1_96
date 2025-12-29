
package com.example.demo.controller;

import com.example.demo.dto.LeaveRequestDto;
import com.example.demo.service.LeaveRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import java.util.List;

@RestController
@RequestMapping("/api/leaves")
@SecurityRequirement(name = "bearerAuth")
public class LeaveRequestController {

    private final LeaveRequestService service;

    public LeaveRequestController(LeaveRequestService service) {
        this.service = service;
    }

    // 1. Submit leave
    @PostMapping
    public ResponseEntity<LeaveRequestDto> create(@RequestBody LeaveRequestDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    // 2. Approve leave
    @PutMapping("/{id}/approve")
    public ResponseEntity<LeaveRequestDto> approve(@PathVariable Long id) {
        return ResponseEntity.ok(service.approve(id));
    }

    // 3. Reject leave ✅ (MISSING EARLIER)
    @PutMapping("/{id}/reject")
    public ResponseEntity<LeaveRequestDto> reject(@PathVariable Long id) {
        return ResponseEntity.ok(service.reject(id));
    }

    // 4. Get leaves by employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveRequestDto>> getByEmployee(
            @PathVariable Long employeeId
    ) {
        return ResponseEntity.ok(service.getByEmployee(employeeId));
    }
   
  
}
