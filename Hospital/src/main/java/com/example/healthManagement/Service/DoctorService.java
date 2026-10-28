package com.example.healthManagement.Service ;

import com.example.healthManagement.entity.Doctor;
import com.example.healthManagement.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository dr;

    // Get all doctors
    public List<Doctor> getall() {
        return dr.findAll();
    }

    // Get single doctor
    public Doctor single(Long id) {
        return dr.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));
    }

    // Add doctor
    public Doctor add(Doctor doctor) {
        return dr.save(doctor);
    }

    // Update doctor
    public Doctor update(Doctor doctor, Long id) {

        Doctor oldDoctor = dr.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));

        oldDoctor.setDoctorName(doctor.getDoctorName());
        oldDoctor.setPhoneNumber(doctor.getPhoneNumber());
        oldDoctor.setEmail(doctor.getEmail());
        oldDoctor.setSpecialization(doctor.getSpecialization());

        return dr.save(oldDoctor);
    }

    // Delete doctor
    public Doctor delete(Long id) {

        Doctor oldDoctor = dr.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found"));

        dr.deleteById(id);

        return oldDoctor;
    }
}
