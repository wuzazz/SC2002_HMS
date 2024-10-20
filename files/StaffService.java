import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StaffService {

    private Map<String, Staff> staffMap; // Store staff members using a HashMap with staffId as key

    public StaffService() {
        staffMap = new HashMap<>();
        // Pre-load sample staff members with role passed as parameter
        addStaff(new Staff("doctor123", "password", "Dr. Smith", "Doctor"));
        addStaff(new Staff("pharmacist123", "password", "Jane Doe", "Pharmacist"));
    }

    // Add a new staff member
    public void addStaff(Staff staff) {
        staffMap.put(staff.getUserId(), staff);
        System.out.println("Staff member added: " + staff.getName());
    }

    // Remove a staff member
    public void removeStaff(String staffId) {
        if (staffMap.remove(staffId) != null) {
            System.out.println("Staff member removed with ID: " + staffId);
        } else {
            System.out.println("Staff member with ID " + staffId + " not found.");
        }
    }

    // Update a staff member's information
    public void updateStaff(String staffId, String newName, String newPassword) {
        Staff staff = staffMap.get(staffId);
        if (staff != null) {
            staff.setName(newName);
            staff.setPassword(newPassword);
            System.out.println("Staff member updated: " + staff.getName());
        } else {
            System.out.println("Staff member with ID " + staffId + " not found.");
        }
    }

    // View all staff members
    public List<Staff> getAllStaff() {
        return List.copyOf(staffMap.values());
    }

    // View staff by role
    public List<Staff> getStaffByRole(String role) {
        return staffMap.values().stream()
                .filter(staff -> staff.getRole().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }
}
