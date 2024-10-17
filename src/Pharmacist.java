public class Pharmacist extends User {
    private String name;
    private String contactInfo;

    public Pharmacist(String userId, String name) {
        super(userId, "Pharmacist");
        this.name = name;
    }

    public void viewPrescriptions() {
        System.out.println("Viewing all prescriptions for pharmacist: " + name);
    }

    public void updatePrescriptionStatus(String prescriptionId, String status) {
        System.out.println("Prescription " + prescriptionId + " status updated to: " + status);
    }

    @Override
    public void displayUserInfo() {
        super.displayUserInfo();
        System.out.println("Name: " + name);
    }
}
