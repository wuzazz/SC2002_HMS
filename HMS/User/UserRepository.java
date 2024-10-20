package User;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class UserRepository {
    private Map<String, User> users; // Map to store users
    private IDGenerator idGenerator; // Declaration of IDGenerator

    // Constructor to initialize the UserRepository
    public UserRepository() {
        this.users = new HashMap<>(); // Initialize users map
        this.idGenerator = new IDGenerator(); // Initialize IDGenerator
        loadData(); // Load existing user data
    }

	public User findUserById(String userID) {
        return users.get(userID); // Return the User object if found, otherwise null
    }
    
	public void addUser(String role, String password, String... details) {
        String userID = idGenerator.generateUniqueUserID(users, role); // Pass users map to IDGenerator
        if (userID != null) {
            User newUser;

            // Instantiate the correct User subclass based on the role
            switch (role.toUpperCase()) {
                case "PATIENT":
                    newUser = new Patient(userID, password, details[0], details[1], details[2], details[3], details[4]);
                    break;
                case "DOCTOR":
                    newUser = new Doctor(userID, password, details[0], Integer.parseInt(details[1]), details[2]);
                    break;
                case "PHARMACIST":
                    newUser = new Pharmacist(userID, password, details[0], Integer.parseInt(details[1]), details[2]);
                    break;
                case "ADMINISTRATOR":
                    newUser = new Administrator(userID, password);
                    break;
                // Add cases for other roles (Admin, Pharmacist, etc.)
                default:
                    System.out.println("Unknown role: " + role);
                    return; // Exit if the role is not recognized
            }

            users.put(userID, newUser); // Store the new user
            saveData(); // Save the updated user data to the file
            System.out.println("User " + userID + " added successfully.");
        } else {
            System.out.println("Unable to generate a unique user ID.");
        }
    }
    
    public boolean verifyUser(String userID, String password) {
        User user = users.get(userID);
        return user != null && user.getPassword().equals(password);
    }
    
    public String getUserRole(String userID) {
        User user = users.get(userID);
        return user != null ? user.getRole() : null;
    }

	public void removeUser(String userID) {
		User user = findUserById(userID); // Get the User object
	
		if (user != null) {
			users.remove(userID); // Remove the user from the map
			saveData(); // Save the updated user data to the file
			System.out.println("User " + user.getUserID() + " removed successfully.");
		} else {
			System.out.println("User ID not found. Removal failed.");
		}
	}
	

    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] userData = line.split(",");
                String userID = userData[0];
                String password = userData[1];
                String role = userData[2];
    
                User user = null; // Declare user as null initially
    
                // Create the appropriate user subclass based on the role
                switch (role) {
                    case "PATIENT":
                        String name = userData[3];
                        String dob = userData[4];
                        String gender = userData[5];
                        String bloodGroup = userData[6];
                        String contactInfo = userData[7];
                        user = new Patient(userID, password, name, dob, gender, bloodGroup, contactInfo);
                        break;
    
                    case "DOCTOR":
                        String docName = userData[3];
                        int age = Integer.parseInt(userData[4]);
                        String docGender = userData[5];
                        user = new Doctor(userID, password, docName, age, docGender);
                        break;
    
                    case "PHARMACIST":
                        String pharmName = userData[3];
                        int pharmAge = Integer.parseInt(userData[4]);
                        String pharmGender = userData[5];
                        user = new Pharmacist(userID, password, pharmName, pharmAge, pharmGender);
                        break;
    
                    // Add more cases for other roles as needed
                    default:
                        System.out.println("Unknown role: " + role);
                        break;
                }
    
                if (user != null) { // Only add the user if it was successfully created
                    users.put(user.getUserID(), user);
                }
            }
        } catch (IOException e) {
            System.out.println("Error loading user data");
        }
    }
    
    
    private void saveData() {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt"))){
            for(User user : users.values()) {
                bw.write(user.getUserID() + "," + user.getPassword() + "," + user.getRole());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving user data");
        }
    }
    
    public void changePassword(String userID, String oldPassword, String newPassword) {
        if (verifyUser(userID, oldPassword)) {
            users.get(userID).setPassword(newPassword); // Assume you have a setPassword method in User
            saveData();
            System.out.println("Password changed successfully.");
        } else {
            System.out.println("Old password is incorrect. Password change failed.");
        }
    }
}
