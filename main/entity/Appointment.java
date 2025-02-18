package com.example.hospital.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private LocalDateTime appointmentDate;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    // Default constructor
    public Appointment() {}

    // Parameterized constructor
    public Appointment(LocalDateTime appointmentDate, Doctor doctor, Patient patient) {
        this.appointmentDate = appointmentDate;
        this.doctor = doctor;
        this.patient = patient;
    }

    // Getters and setters
    public Long getId() 
    {
        return id;
    }
    
    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }    
    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }    
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    public Patient getPatient() {
        return patient;
    }    
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}

