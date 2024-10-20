package User;
public class Doctor extends User {
    private String name;
    private int age;
    private String gender;

    public Doctor(String userID, String password, String name, int age, String gender) {
        super(userID, password, "DOCTOR");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public void viewPatientRecords() {
        System.out.println("Viewing patient records for doctor: " + name);
    }

    public void setAvailability(String availability) {
        System.out.println("Doctor availability set to: " + availability);
    }

    @Override
    public String getDetails() {
        return "Doctor: Age: " + age + ", Gender: " + gender;
    }
}
