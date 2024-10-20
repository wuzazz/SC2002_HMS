package User;
public class Administrator extends User {

    public Administrator(String userID, String password) {
        super(userID, password, "ADMINISTRATOR");
    }

    public void manageStaff() {
        System.out.println("Managing staff for administrator: ");
    }

    public void viewAppointments() {
        System.out.println("Viewing appointments for administrator: ");
    }

    @Override
    public String getDetails() {
        return "";
    }
}
