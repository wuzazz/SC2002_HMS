package models;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private String status; // e.g., "Confirmed", "Cancelled", "Completed"

    public Appointment(String appointmentId, String patientId, String doctorId, String appointmentDate, String appointmentTime, String status) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.status = status;
    }

    // Getters and Setters
    public String getAppointmentId() {
        return appointmentId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    // Method to update appointment status
    public void updateStatus(String status) {
        this.status = status;
    }
}
