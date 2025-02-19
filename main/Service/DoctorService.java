package com.example.hospital.service;

import com.example.hospital.model.Doctor;
import com.example.hospital.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService 
{

    private final DoctorRepository doctorRepository;
    
    public DoctorService(DoctorRepository doctorRepository) 
    {
        this.doctorRepository = doctorRepository;
    }
    
    public List<Doctor> getAllDoctors()
    {
        return doctorRepository.findAll();
    }
    
    public Optional<Doctor> getDoctorById(Long id)
    {
        return doctorRepository.findById(id);
    }
    
    public Doctor createDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }
    
    public Doctor updateDoctor(Long id, Doctor doctorDetails){
        return doctorRepository.findById(id).map(doctor -> {
            doctor.setName(doctorDetails.getName());
            doctor.setSpecialization(doctorDetails.getSpecialization());
            return doctorRepository.save(doctor);
        }).orElseThrow(() -> new RuntimeException("Doctor not found with id " + id));
    }
    
    public void deleteDoctor(Long id){
        doctorRepository.deleteById(id);
    }
}

