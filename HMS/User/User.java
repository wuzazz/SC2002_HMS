package User;
public abstract class User {
    private String userID;
    private String password;
    private String role;

    public User(String userID, String password, String role) {
        this.userID = userID;
        this.password = password;
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setPassword(String password) {
        this.password = password; // Add this method to allow changing the password
    }

    // Abstract method for role-specific details
    public abstract String getDetails();
}
