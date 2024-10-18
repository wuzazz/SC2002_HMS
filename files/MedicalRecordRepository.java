package repositories;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class MedicalRecordRepository {
    private Map<String, MedicalRecord> medicalRecords;

    public MedicalRecordRepository() {
        this.medicalRecords = new HashMap<>();
        loadData();
    }

    // Adds or updates a medical record for a patient
    public void addOrUpdateRecord(String patientId, MedicalRecord record) {
        medicalRecords.put(patientId, record);
        saveData();
    }

    // Retrieves a medical record for a specific patient
    public MedicalRecord getRecord(String patientId) {
        return medicalRecords.get(patientId);
    }

    // Load medical records from file
    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("medical_records.dat"))) {
            medicalRecords = (Map<String, MedicalRecord>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading medical record data.");
        }
    }

    // Save medical records to file
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("medical_records.dat"))) {
            oos.writeObject(medicalRecords);
        } catch (IOException e) {
            System.out.println("Error saving medical record data.");
        }
    }
}
