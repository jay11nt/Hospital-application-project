# Hospital-application-project

- This is a complete sample Spring Boot project using Java that demonstrates basic OOP concepts, JPA entity relationships etc.

 ## Features

- **CRUD APIs** for Doctors, Patients, and Appointments.
- **JPA Relationships**:
  - One-to-Many: A Doctor can have multiple Appointments.
  - One-to-Many: A Patient can have multiple Appointments.
  - Many-to-One: Each Appointment is linked to a single Doctor and a single Patient.
- Uses an **in-memory H2 database** for quick testing.
- Easy testing with **Postman**.
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

## Technologies Used

- Java 8+
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

**🚀 API Endpoints-**

### Testing with Postman :-

🔹 Doctor API-

| HTTP Method| Endpoint           | Description         |
|------------|--------------------|---------------------|
| GET        | /api/doctors       | Get all doctors     |
| GET        | /api/doctors/{id}  | Get doctor by ID    |
| POST       | /api/doctors       | Create new doctor   |
| PUT        | /api/doctors/{id}  | Update doctor       |
| DELETE     | /api/doctors/{id}  | Delete doctor       |


  **Create a Doctor:**
  `POST http://localhost:8080/api/doctors`

Body (JSON): 

        {
          "name": "Dr. ROY",
          "specialization": "Cardiology"
        }

  **Get All Doctors:**
  `GET http://localhost:8080/api/doctors`


🔹 Patient API -

| HTTP Method| Endpoint             | Description         |
|------------|----------------------|---------------------|
| GET        | /api/doctors         | Get all doctors     |
| GET        | /api/doctors/{id}    | Get doctor by ID    |
| POST       | /api/doctors         | Create new doctor   |
| PUT        | /api/doctors/{id}    | Update doctor       |
| DELETE     | /api/doctors/{id}    | Delete doctor       |
| GET        | /api/patients        | Get all patients    |
| GET        | /api/patients/{id}   | Get patient by ID   |
| POST       | /api/patients        | Create new patient  |
| PUT        | /api/patients/{id}   | Update patient      |
| DELETE     | /api/patients/{id}   | Delete patient      |


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


🔹 Appointment API

| HTTP Method| Endpoint                | Description           |
|------------|-------------------------|-----------------------|
| GET        | /api/doctors            | Get all doctors       |
| GET        | /api/doctors/{id}       | Get doctor by ID      |
| POST       | /api/doctors            | Create new doctor     |
| PUT        | /api/doctors/{id}       | Update doctor         |
| DELETE     | /api/doctors/{id}       | Delete doctor         |
| GET        | /api/patients           | Get all patients      |
| GET        | /api/patients/{id}      | Get patient by ID     |
| POST       | /api/patients           | Create new patient    |
| PUT        | /api/patients/{id}      | Update patient        |
| DELETE     | /api/patients/{id}      | Delete patient        |
| GET        | /api/appointments       | Get all appointments  |
| GET        | /api/appointments/{id}  | Get appointment by ID |
| POST       | /api/appointments       | Create appointment    |
| PUT        | /api/appointments/{id}  | Update appointment    |
| DELETE     | /api/appointments/{id}  | Delete appointment    |

  
**Create an Appointment:**
`POST http://localhost:8080/api/appointments?doctorId=1&patientId=1`


Body (JSON):

        {
          "appointmentDate": "2025-02-17 T10:30:00"
        }
        
  **Get All Appointments:**
`GET http://localhost:8080/api/appointments`
