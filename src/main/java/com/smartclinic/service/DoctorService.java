package com.smartclinic.service;

import com.smartclinic.model.Doctor;
import com.smartclinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<String> getAvailableTimeSlots(Long doctorId, LocalDate date) {
        Optional<Doctor> doctorOpt = doctorRepository.findById(doctorId);
        if (doctorOpt.isPresent()) {
            return doctorOpt.get().getAvailableTimes();
        }
        return Collections.emptyList();
    }

    public ResponseEntity<Map<String, Object>> validateDoctorCredentials(String email, String password) {
        Map<String, Object> response = new HashMap<>();
        if ("doctor@smartclinic.com".equals(email) && "password123".equals(password)) {
            response.put("status", "SUCCESS");
            response.put("message", "Login successful");
            return ResponseEntity.ok(response);
        } else {
            response.put("status", "ERROR");
            response.put("message", "Invalid credentials");
            return ResponseEntity.status(401).body(response);
        }
    }
}
