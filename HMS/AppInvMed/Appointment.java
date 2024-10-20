package Appointment;

import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private String patientId;       // Patient ID
    private String doctorId;        // Doctor ID
    private String date;            // Date of the appointment
    private String time;            // Time of the appointment
    private String status;          // Status: confirmed, canceled, completed
    private String serviceType;     // Type of service provided
    private List<Medication> prescribedMedications; // List of medications prescribed
    private String consultationNotes; // Notes from the doctor

    public Appointment(String patientId, String doctorId, String date, String time) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.status = "pending"; // Initial status when appointment is created
        this.prescribedMedications = new ArrayList<>();
        this.consultationNotes = "";
    }

    // Getters and setters for various fields
    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public List<Medication> getPrescribedMedications() {
        return prescribedMedications;
    }

    public void addPrescribedMedication(Medication medication) {
        this.prescribedMedications.add(medication);
    }

    public String getConsultationNotes() {
        return consultationNotes;
    }

    public void setConsultationNotes(String consultationNotes) {
        this.consultationNotes = consultationNotes;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "patientId='" + patientId + '\'' +
                ", doctorId='" + doctorId + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", status='" + status + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", prescribedMedications=" + prescribedMedications +
                ", consultationNotes='" + consultationNotes + '\'' +
                '}';
    }
}
