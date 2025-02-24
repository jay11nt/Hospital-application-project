
package com.example.hospital.controller;

import com.example.hospital.model.Appointment;
import com.example.hospital.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController 
{

    private final AppointmentService appointmentService;
    
    public AppointmentController(AppointmentService appointmentService)
    {
        this.appointmentService = appointmentService;
    }
    
    @GetMapping
    public List<Appointment> getAllAppointments(){
        return appointmentService.getAllAppointments();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable Long id)
    {
        return appointmentService.getAppointmentById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
    /**
     * Create an appointment.
     * Pass doctorId and patientId as query parameters.
     * Example URL:
     *   POST /api/appointments?doctorId=1&patientId=2
     * With a JSON body:
     * {
     *   "appointmentDate": "2025-02-17T10:30:00"
     * }
     */
    @PostMapping
    public Appointment createAppointment(
            @RequestParam Long doctorId,
            @RequestParam Long patientId,
            @RequestBody Appointment appointment)
    {
        return appointmentService.createAppointment(appointment, doctorId, patientId);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Appointment> updateAppointment(
            @PathVariable Long id,
            @RequestParam Long doctorId,
            @RequestParam Long patientId,
            @RequestBody Appointment appointment){
        try {
            Appointment updatedAppointment = appointmentService.updateAppointment(id, appointment, doctorId, patientId);
            return ResponseEntity.ok(updatedAppointment);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.noContent().build();
    }
}
