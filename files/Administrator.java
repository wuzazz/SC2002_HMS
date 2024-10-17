public class Administrator extends User {
    private String name;

    public Administrator(String userId, String name) {
        super(userId, "Administrator");
        this.name = name;
    }

    public void manageStaff() {
        System.out.println("Managing staff for administrator: " + name);
    }

    public void viewAppointments() {
        System.out.println("Viewing appointments for administrator: " + name);
    }

    @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Name: " + name);
    }
}
