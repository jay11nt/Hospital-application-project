# Hospital-application-project

- This is a complete sample Spring Boot project using Java that demonstrates basic OOP concepts, JPA entity relationships etc.

  we have three entities—  **Doctor, Patient, and Appointment.**

 **with the following relationships:**

- Doctor: Has many Appointments.
- Patient: Has many Appointments.
- Appointment: Belongs to one Doctor and one Patient.

### **Project Structure :- **
      src
      └── main
          └── java
               └── com.example.hospital
                    ├── HospitalApplication.java
                    ├── model
                    │      ├── Doctor.java
                    │      ├── Patient.java
                    │      └── Appointment.java
                    ├── repository
                    │      ├── DoctorRepository.java
                    │      ├── PatientRepository.java
                    │      └── AppointmentRepository.java
                    ├── service
                    │      ├── DoctorService.java
                    │      ├── PatientService.java
                    │      └── AppointmentService.java
                    └── controller
                           ├── DoctorController.java
                           ├── PatientController.java
                           └── AppointmentController.java
