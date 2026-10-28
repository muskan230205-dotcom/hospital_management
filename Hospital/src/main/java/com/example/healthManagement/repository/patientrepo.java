package com.example.healthManagement.repository;



import com.example.healthManagement.entity.patient;
import com.example.healthManagement.entity.patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface patientrepo extends JpaRepository<patient, Long> {
//    patient findByPatientCode(String pc);

    Optional<patient> findByPatientcode(String patientcode);

    Optional<patient> findByEmail(String email);

    Optional<patient> findByPhoneNumber(String phoneNumber);

    Optional<patient> findByAadharNumber(String aadharNumber);
}

