package com.example.hospital.service;

import com.example.hospital.model.Appointment;
import com.example.hospital.model.Doctor;
import com.example.hospital.model.Patient;
import com.example.hospital.repository.AppointmentRepository;
import com.example.hospital.repository.DoctorRepository;
import com.example.hospital.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    
    public AppointmentService(AppointmentRepository appointmentRepository, 
                              DoctorRepository doctorRepository,
                              PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }
    
    public List<Appointment> getAllAppointments(){
        return appointmentRepository.findAll();
    }
    
    public Optional<Appointment> getAppointmentById(Long id){
        return appointmentRepository.findById(id);
    }
    
    // Create an appointment by linking to an existing doctor and patient.
    public Appointment createAppointment(Appointment appointment, Long doctorId, Long patientId){
        Doctor doctor = doctorRepository.findById(doctorId)
            .orElseThrow(() -> new RuntimeException("Doctor not found with id " + doctorId));
        Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new RuntimeException("Patient not found with id " + patientId));
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }
    
    public Appointment updateAppointment(Long id, Appointment appointmentDetails, Long doctorId, Long patientId){
        return appointmentRepository.findById(id).map(appointment -> {
            appointment.setAppointmentDate(appointmentDetails.getAppointmentDate());
            Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id " + doctorId));
            Patient patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found with id " + patientId));
            appointment.setDoctor(doctor);
            appointment.setPatient(patient);
            return appointmentRepository.save(appointment);
        }).orElseThrow(() -> new RuntimeException("Appointment not found with id " + id));
    }
    
    public void deleteAppointment(Long id){
        appointmentRepository.deleteById(id);
    }
}

