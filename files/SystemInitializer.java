package repositories;
public class SystemInitializer {
    private UserRepository userRepository;
    private AppointmentRepository appointmentRepository;
    private MedicalRecordRepository medicalRecordRepository;
    private InventoryRepository inventoryRepository;

    public SystemInitializer() {
        this.userRepository = new UserRepository();
        this.appointmentRepository = new AppointmentRepository();
        this.medicalRecordRepository = new MedicalRecordRepository();
        this.inventoryRepository = new InventoryRepository();
    }

    // Initializes the system with data
    public void initialize() {
        // Load initial users, appointments, medical records, inventory, etc.
        userRepository.loadData();
        appointmentRepository.loadData();
        medicalRecordRepository.loadData();
        inventoryRepository.loadData();

        System.out.println("System initialized successfully.");
    }
}
