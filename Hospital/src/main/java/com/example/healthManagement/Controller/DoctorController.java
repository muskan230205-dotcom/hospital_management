package com.example.healthManagement.Controller;



import com.example.healthManagement.entity.Doctor;
import com.example.healthManagement.Service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService ds;

    // Get all doctors
    @GetMapping("/all")
    public List<Doctor> getall() {
        return ds.getall();
    }

    // Get single doctor
    @GetMapping("/{id}")
    public Doctor single(@PathVariable Long id) {
        return ds.single(id);
    }

    // Add doctor
    @PostMapping("/add")
    public Doctor add(@RequestBody Doctor doctor) {
        return ds.add(doctor);
    }

    // Update doctor
    @PutMapping("/update/{id}")
    public Doctor update(@RequestBody Doctor doctor,
                         @PathVariable Long id) {
        return ds.update(doctor, id);
    }

    // Delete doctor
    @DeleteMapping("/delete/{id}")
    public Doctor delete(@PathVariable Long id) {
        return ds.delete(id);
    }
}
