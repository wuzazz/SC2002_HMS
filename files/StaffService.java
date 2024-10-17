import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StaffService {

    private List<Staff> staffList;

    public StaffService() {
        staffList = new ArrayList<>();
        // Pre-load sample staff members (doctors and pharmacists)
        staffList.add(new Doctor("doctor123", "password", "Dr. Smith"));
        staffList.add(new Pharmacist("pharmacist123", "password", "Jane Doe"));
    }

    // Add a new staff member
    public void addStaff(Staff staff) {
        staffList.add(staff);
        System.out.println("Staff member added: " + staff.getName());
    }

    // Remove a staff member
    public void removeStaff(String staffId) {
        staffList.removeIf(staff -> staff.getUserId().equals(staffId));
        System.out.println("Staff member removed with ID: " + staffId);
    }

    // Update a staff member's information
    public void updateStaff(String staffId, String newName, String newPassword) {
        for (Staff staff : staffList) {
            if (staff.getUserId().equals(staffId)) {
                staff.setName(newName);
                staff.setPassword(newPassword);
                System.out.println("Staff member updated: " + staff.getName());
                return;
            }
        }
        System.out.println("Staff member with ID " + staffId + " not found.");
    }

    // View all staff members
    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffList);
    }

    // View staff by role
    public List<Staff> getStaffByRole(String role) {
        return staffList.stream()
                .filter(staff -> staff.getClass().getSimpleName().equalsIgnoreCase(role))
                .collect(Collectors.toList());
    }
}
