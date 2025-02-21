package com.example.hospital.controller;

import com.example.hospital.model.Doctor;
import com.example.hospital.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController 
{

    private final DoctorService doctorService;
    
    public DoctorController(DoctorService doctorService)
    {
        this.doctorService = doctorService;
    }
    
    @GetMapping
    public List<Doctor> getAllDoctors()
    {
        return doctorService.getAllDoctors();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id)
    {
        return doctorService.getDoctorById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor)
    {
        return doctorService.createDoctor(doctor);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor)
    {
        try {
            Doctor updatedDoctor = doctorService.updateDoctor(id, doctor);
            return ResponseEntity.ok(updatedDoctor);
            } 
        catch (RuntimeException e) 
            {
            return ResponseEntity.notFound().build();
            }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable Long id)
    {
        doctorService.deleteDoctor(id);
        return ResponseEntity.noContent().build();
    }
}

