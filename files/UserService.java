import java.util.HashMap;
import java.util.Map;

public class UserService {

    // Store users in a map for quick lookup (In a real app, this would be a database)
    private Map<String, User> users;

    public UserService() {
        users = new HashMap<>();
        // Pre-load some sample users (Patient, Doctor, Pharmacist, Admin)
        users.put("patient123", new Patient("patient123", "password", "John Doe", "johndoe@gmail.com", "1234567890"));
        users.put("doctor123", new Doctor("doctor123", "password", "Dr. Smith"));
        users.put("pharmacist123", new Pharmacist("pharmacist123", "password", "Jane Doe"));
        users.put("admin123", new Admin("admin123", "password", "Admin"));
    }

    // Login method: Validate user credentials and return user role-specific access
    public User login(String userId, String password) {
        User user = users.get(userId);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful!");
            return user;
        } else {
            System.out.println("Invalid credentials.");
            return null;
        }
    }

    // Change password method
    public boolean changePassword(String userId, String oldPassword, String newPassword) {
        User user = users.get(userId);
        if (user != null && user.getPassword().equals(oldPassword)) {
            user.setPassword(newPassword);
            System.out.println("Password updated successfully.");
            return true;
        } else {
            System.out.println("Old password does not match.");
            return false;
        }
    }

    // Get user by ID
    public User getUserById(String userId) {
        return users.get(userId);
    }

    // Add a new user (for admin use)
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    // Remove a user (for admin use)
    public void removeUser(String userId) {
        users.remove(userId);
    }
}
