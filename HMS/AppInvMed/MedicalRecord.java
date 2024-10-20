package models;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecord {
    private String patientId;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String contactInfo;
    private String bloodType;
    private List<String> pastDiagnoses;
    private List<String> treatments;

    public MedicalRecord(String patientId, String name, String dateOfBirth, String gender, String contactInfo, String bloodType) {
        this.patientId = patientId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.bloodType = bloodType;
        this.pastDiagnoses = new ArrayList<>();
        this.treatments = new ArrayList<>();
    }

    // Getters and Setters
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getBloodType() {
        return bloodType;
    }

    public List<String> getPastDiagnoses() {
        return pastDiagnoses;
    }

    public List<String> getTreatments() {
        return treatments;
    }

    // Methods to update contact information
    public void updateContact(String phoneNumber, String email) {
        this.contactInfo = "Phone: " + phoneNumber + ", Email: " + email;
    }

    // Methods to add diagnoses and treatments
    public void addDiagnosis(String diagnosis) {
        this.pastDiagnoses.add(diagnosis);
    }

    public void addTreatment(String treatment) {
        this.treatments.add(treatment);
    }
}
