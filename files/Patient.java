public class Patient extends User {
    private String name;
    private String dob;  // Date of birth
    private String gender;
    private String contactInfo;
    private String bloodType;

    public Patient(String userId, String name, String dob, String gender, String contactInfo, String bloodType) {
        super(userId, "Patient");
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.contactInfo = contactInfo;
        this.bloodType = bloodType;
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

    @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Name: " + name);
        System.out.println("DOB: " + dob);
        System.out.println("Gender: " + gender);
        System.out.println("Contact Info: " + contactInfo);
        System.out.println("Blood Type: " + bloodType);
    }
}
