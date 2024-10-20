package User;

public class Pharmacist extends User {
    private String name;     // Pharmacist's name
    private int age;         // Pharmacist's age
    private String gender;    // Pharmacist's gender

    // Constructor for Pharmacist
    public Pharmacist(String userID, String password, String name, int age, String gender) {
        super(userID, password, "PHARMACIST"); // Call the superclass constructor
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Getters for Pharmacist's fields
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void viewPrescriptions() {
        System.out.println("Viewing all prescriptions for pharmacist: " + name);
    }

    public void updatePrescriptionStatus(String prescriptionId, String status) {
        System.out.println("Prescription " + prescriptionId + " status updated to: " + status);
    }

    // Method to get details about the pharmacist
    @Override
    public String getDetails() {
        return "Pharmacist: " + name + ", Age: " + age + ", Gender: " + gender;
    }
}
