import java.util.Map;

public class IDGenerator {
    
    // Method to generate a unique user ID based on the role
    public String generateUniqueUserID(Map<String, User> users, String role) {
        char roleCode = getRoleCode(role);
        if (roleCode == ' ') return null; // Invalid role

        int idNumber = 1; // Start from 0001
        String userID;

        do {
            userID = String.format("%c%04d", roleCode, idNumber); // Format ID
            idNumber++;
        } while (users.containsKey(userID) && idNumber <= 9999); // Ensure uniqueness and max ID limit

        return idNumber > 9999 ? null : userID; // Return null if max ID limit reached
    }

    // Method to get the role code for a given role
    private char getRoleCode(String role) {
        switch (role.toUpperCase()) {
            case "PATIENT":
                return 'P';
            case "DOCTOR":
                return 'D';
            case "ADMIN":
                return 'A';
            case "PHARMACIST":
                return 'H';
            default:
                return ' '; // Invalid role
        }
    }
}
