# Hospital-application-project

- This is a complete sample Spring Boot project using Java that demonstrates basic OOP concepts, JPA entity relationships etc.

  we have three entities—  **Doctor, Patient, and Appointment.**

 **with the following relationships:**

- Doctor: Has many Appointments.
- Patient: Has many Appointments.
- Appointment: Belongs to one Doctor and one Patient.

### **Project Structure :-**
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

### Testing with Postman :-
- **Doctor APIs-**

  **Create a Doctor:**
  `POST http://localhost:8080/api/doctors`

Body (JSON): 

        {
          "name": "Dr. ROY",
          "specialization": "Cardiology"
        }

  **Get All Doctors:**
  `GET http://localhost:8080/api/doctors`


- **Patient APIs-**

**Create a Patient:**
`POST http://localhost:8080/api/patients`

Body (JSON):

        {
          "name": "hitesh soni",
          "age": 29,
          "email": "hiteshsoni@gmail.com"
        }

  **Get All Patients:**
  `GET http://localhost:8080/api/patients`

- **Appointment APIs-**
  
**Create an Appointment:**
`POST http://localhost:8080/api/appointments?doctorId=1&patientId=1`


Body (JSON):

        {
          "appointmentDate": "2025-02-17 T10:30:00"
        }
        
  **Get All Appointments:**
`GET http://localhost:8080/api/appointments`
