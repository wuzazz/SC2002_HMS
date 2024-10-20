package models;

public class Prescription {
    private String prescriptionId;
    private String appointmentId;
    private String medicationName;
    private String dosage;
    private String status; // "Pending", "Dispensed"

    public Prescription(String prescriptionId, String appointmentId, String medicationName, String dosage) {
        this.prescriptionId = prescriptionId;
        this.appointmentId = appointmentId;
        this.medicationName = medicationName;
        this.dosage = dosage;
        this.status = "Pending";
    }

    // Getters and Setters
    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getAppointmentId() {
        return appointmentId;
    }

    public String getMedicationName() {
        return medicationName;
    }

    public String getDosage() {
        return dosage;
    }

    public String getStatus() {
        return status;
    }

    // Method to update prescription status
    public void updateStatus(String status) {
        this.status = status;
    }
}

