package com.smartclinic.controller;

import com.smartclinic.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createPrescription(
            @RequestHeader("Authorization") String token,
            @RequestBody Map<String, Object> prescriptionData) {

        Map<String, String> response = new HashMap<>();
        String jwt = token.replace("Bearer ", "");

        if (!tokenService.validateToken(jwt)) {
            response.put("error", "Unauthorized access");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        if (prescriptionData == null || !prescriptionData.containsKey("medication")) {
            response.put("error", "Invalid prescription request body");
            return ResponseEntity.badRequest().body(response);
        }

        response.put("message", "Prescription created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
