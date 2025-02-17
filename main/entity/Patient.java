package com.example.hospital.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private Integer age;
    private String email;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Appointment> appointments;

    // Default constructor
    public Patient() {}

    // Parameterized constructor
    public Patient(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }    
    public void setName(String name) {
        this.name = name;
    }
    
    public Integer getAge() {
        return age;
    }    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getEmail() {
        return email;
    }    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}

