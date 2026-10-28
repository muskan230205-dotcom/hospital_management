package com.example.healthManagement.Service;

import com.example.healthManagement.Exception.ResourceNotFound;
import com.example.healthManagement.dto.patientMapper;
import com.example.healthManagement.dto.patientRequest;
import com.example.healthManagement.dto.patientResponse;
import com.example.healthManagement.entity.patient;
import com.example.healthManagement.repository.patientrepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class patientService {

    private final patientrepo re;
    private final patientMapper pm;

    // Get all patients
    public List<patient> getall() {
        return re.findAll();
    }

    // Get single patient
    public patient single(Long id) {
        return re.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));
    }

    // Add patient
    public patientResponse add(patientRequest pt) {

        if (re.findByPatientcode(pt.getPatientCode()).isPresent()) {
            log.warn ("duplicate patient");
            throw new ResourceNotFound("Patient already exists");

        }

        if (re.findByAadharNumber(pt.getAadharNumber()).isPresent()) {
            log.warn ("duplicate Aadhar number");
            throw new ResourceNotFound("Aadhar already exists");
        }

        if (re.findByEmail(pt.getEmail()).isPresent()) {
            log.warn ("duplicate Email");
            throw new ResourceNotFound("Email already exists");
        }

        if (re.findByPhoneNumber(pt.getPhoneNumber()).isPresent()) {
            log.warn ("duplicate phone number");
            throw new ResourceNotFound("Phone number already exists");
        }

        patient p = pm.toentity(pt);
        patient s = re.save(p);
        log.info("Data added successfully");
        return pm.toResponce(s);

    }

    // Update patient
    public patientResponse update(patientRequest pt, Long id) {

        patient oldpatient = re.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));
        pm.updatePatientFromRequest(pt,oldpatient);

//        oldpatient.setPatientcode(pt.getPatientCode());
//        oldpatient.setFirstName(pt.getFirstName());
//        oldpatient.setLastName(pt.getLastName());
//        oldpatient.setAge(pt.getAge());
//        oldpatient.setGender(gender.valueOf(pt.getGender()));
//        oldpatient.setPhoneNumber(pt.getPhoneNumber());
//        oldpatient.setEmail(pt.getEmail());
//        oldpatient.setBloodGroup(bloodgroup.valueOf(pt.getBloodGroup()));
//        oldpatient.setAadharNumber(pt.getAadharNumber());
//        oldpatient.setAddress(pt.getAddress());
//        oldpatient.setEmergencyContact(pt.getEmergencyContact());
//        oldpatient.setAdmitDate(pt.getAdmitDate());
//        oldpatient.setStatus(patientstatus.valueOf(pt.getStatus()));

        patient up=re.save(oldpatient);
        log.info("added successfully");
        return pm.toResponce(up);
    }

    // Delete patient
    public patient delete(Long id) {

        patient oldpatient = re.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));

        re.deleteById(id);

        return oldpatient;
    }
}