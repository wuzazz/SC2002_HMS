public class User {
    protected String userId;
    protected String password;
    protected String role;

    public User(String userId, String role) {
        this.userId = userId;
        this.role = role;
        this.password = "password";  // Default password
    }

    // Getters
    public String getUserId() {
        return userId;
    }

    public String getRole() {
        return role;
    }

    // Login function
    public boolean login(String enteredPassword) {
        return this.password.equals(enteredPassword);
    }

    // Change password function
    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

    // Display common user information
    public void displayUserInfo() {
        System.out.println("User ID: " + userId);
        System.out.println("Role: " + role);
    }
}

