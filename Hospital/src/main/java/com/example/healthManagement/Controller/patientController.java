package com.example.healthManagement.Controller;

import com.example.healthManagement.API.API_Response;
import com.example.healthManagement.dto.patientRequest;
import com.example.healthManagement.dto.patientResponse;
import com.example.healthManagement.entity.patient;
import com.example.healthManagement.Service.patientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class patientController {

    private final patientService service;

    // Get all patients
    @GetMapping
    public ResponseEntity<API_Response<List<patient>>> getAll() {

        List<patient> patients = service.getall();

        API_Response<List<patient>> response = new API_Response<>(
                200,
                true,
                "Patients fetched successfully",
                LocalDateTime.now(),
                patients
        );

        return ResponseEntity.ok(response);
    }

    // Add patient
    @PostMapping("/add")
    public ResponseEntity<API_Response<patientResponse>> add(@RequestBody patientRequest p) {

        patientResponse savedPatient = service.add(p);
        API_Response ap = new API_Response(HttpStatus.CREATED.value(),true,"added",LocalDateTime.now(),savedPatient);

        return ResponseEntity.status(HttpStatus.CREATED).body(ap);
    }





    // Get patient by ID
    @GetMapping("/{id}")
    public ResponseEntity<API_Response<patientResponse>> getById(@PathVariable Long id) {

        patient p = service.single(id);

        API_Response<patientResponse> response = new API_Response(
                200,
                true,
                "Patient fetched successfully",
                LocalDateTime.now(),
                p
        );

        return ResponseEntity.ok(response);
    }

    // Update patient
    @PutMapping("/{id}")
    public ResponseEntity<API_Response<patientResponse>> update(
            @RequestBody patientRequest p,
            @PathVariable Long id) {

        patientResponse updatedPatient = service.update(p,id);

        API_Response<patientResponse> response = new API_Response(
                200,
                true,
                "Patient updated successfully",
                LocalDateTime.now(),
                updatedPatient
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // Delete patient
    @DeleteMapping("/{id}")
    public ResponseEntity<API_Response<String>> delete(@PathVariable Long id) {

        service.delete(id);

        API_Response<String> response = new API_Response<>(
                200,
                true,
                "Patient deleted successfully",
                LocalDateTime.now(),
                null
        );

        return ResponseEntity.ok(response);
    }
}