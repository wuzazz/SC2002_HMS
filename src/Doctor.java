public class Doctor extends User {
    private String name;
    private String specialty;
    private String contactInfo;

    public Doctor(String userId, String name, String specialty) {
        super(userId, "Doctor");
        this.name = name;
        this.specialty = specialty;
    }

    public void viewPatientRecords() {
        System.out.println("Viewing patient records for doctor: " + name);
    }

    public void setAvailability(String availability) {
        System.out.println("Doctor availability set to: " + availability);
    }

    @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Name: " + name);
        System.out.println("Specialty: " + specialty);
    }
}
