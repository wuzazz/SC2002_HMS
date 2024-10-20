package User;
public class Patient extends User {
    private String name;
    private String dob;
    private String gender;
    private String bloodGroup;
    private String contactInfo;

    public Patient(String userID, String password, String name, String dob, String gender, String bloodGroup, String contactInfo) {
        super(userID, password, "PATIENT");
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.bloodGroup = bloodGroup;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getGender() {
        return gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    @Override
    public String getDetails() {
        return "Patient: " + name + ", DOB: " + dob + ", Gender: " + gender + ", Blood Group: " + bloodGroup + ", Contact: " + contactInfo;
    }

    // Method to view medical record
    public void viewMedicalRecord() {
        System.out.println("Viewing medical record for patient: " + name);
    }

    // Method to update personal information
    public void updatePersonalInfo(String email, String contactNumber) {
        this.contactInfo = contactNumber;
        System.out.println("Personal information updated successfully.");
    }
}
