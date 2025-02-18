package com.example.hospital.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctor 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String specialization;

    @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    // Default constructor
    public Doctor() {}

    // Parameterized constructor
    public Doctor(String name, String specialization) 
    {
        this.name = name;
        this.specialization = specialization;
    }

    // Getters and setters
    public Long getId() 
    {
        return id;
    }
    
    public String getName() 
    {
        return name;
    }    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public String getSpecialization() 
    {
        return specialization;
    }    
    public void setSpecialization(String specialization) 
    {
        this.specialization = specialization;
    }
    
    public List<Appointment> getAppointments() 
    {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) 
    {
        this.appointments = appointments;
    }
}

