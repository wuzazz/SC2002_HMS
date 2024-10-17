public class App {
    public static void main(String[] args) {
        // Create User instances
        User generalUser = new User("U001", "General");
        Patient patient = new Patient("P001", "John Doe", "01/01/1990", "Male", "john.doe@example.com", "O+");
        Doctor doctor = new Doctor("D001", "Dr. Smith", "Cardiology");
        Pharmacist pharmacist = new Pharmacist("PH001", "Emily");
        Administrator admin = new Administrator("A001", "Admin John");

        // Check if login works for User
        System.out.println("General User login: " + generalUser.login("password")); // Expected: true
        generalUser.changePassword("newpass");
        System.out.println("General User login after password change: " + generalUser.login("newpass")); // Expected: true

        // Display Patient info
        patient.displayUserInfo();
        patient.viewMedicalRecord(); // Dummy view of medical record
        patient.updatePersonalInfo("newemail@example.com", "555-1234");

        // Doctor functionality
        doctor.displayUserInfo();
        doctor.viewPatientRecords(); // Dummy view of patient records
        doctor.setAvailability("Monday 9AM-12PM");

        // Pharmacist functionality
        pharmacist.displayUserInfo();
        pharmacist.viewPrescriptions(); // Dummy view of prescriptions
        pharmacist.updatePrescriptionStatus("RX001", "Dispensed");

        // Administrator functionality
        admin.displayUserInfo();
        admin.manageStaff(); // Dummy staff management
        admin.viewAppointments(); // Dummy view of appointments
    }
}
