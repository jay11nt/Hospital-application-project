package com.example.hospital.service;

import com.example.hospital.model.Patient;
import com.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    private final PatientRepository patientRepository;
    
    public PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }
    
    public List<Patient> getAllPatients(){
        return patientRepository.findAll();
    }
    
    public Optional<Patient> getPatientById(Long id){
        return patientRepository.findById(id);
    }
    
    public Patient createPatient(Patient patient){
        return patientRepository.save(patient);
    }
    
    public Patient updatePatient(Long id, Patient patientDetails){
        return patientRepository.findById(id).map(patient -> {
            patient.setName(patientDetails.getName());
            patient.setAge(patientDetails.getAge());
            patient.setEmail(patientDetails.getEmail());
            return patientRepository.save(patient);
        }).orElseThrow(() -> new RuntimeException("Patient not found with id " + id));
    }
    
    public void deletePatient(Long id){
        patientRepository.deleteById(id);
    }
}

