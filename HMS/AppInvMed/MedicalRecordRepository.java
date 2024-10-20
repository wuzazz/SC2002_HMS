package AI;

import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class MedicalRecordRepository {
    private Map<String, MedicalRecord> records; // Maps patient ID to MedicalRecord object

    public MedicalRecordRepository() {
        this.records = new HashMap<>();
        loadData(); // Load records from the file
    }

    public void addMedicalRecord(MedicalRecord record) {
        records.put(record.getPatientID(), record);
        saveData(); // Save updated records
    }

    public MedicalRecord findByPatientID(String patientID) {
        return records.get(patientID); // Return the MedicalRecord if found, otherwise null
    }

    public void updateMedicalRecord(String patientID, String emailAddress, String contactNumber) {
        MedicalRecord record = findByPatientID(patientID);
        if (record != null) {
            record.updateContactInfo(emailAddress, contactNumber);
            saveData(); // Save updated records
        }
    }

    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("medical_records.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] recordData = line.split(",");
                MedicalRecord record = new MedicalRecord(
                    recordData[0], // patientID
                    recordData[1], // name
                    recordData[2], // dateOfBirth
                    recordData[3], // gender
                    recordData[4], // contactNumber
                    recordData[5], // emailAddress
                    recordData[6]  // bloodType
                );
                // Load past diagnoses and treatments
                for (int i = 7; i < recordData.length; i++) {
                    record.addDiagnosis(recordData[i]); // Assume diagnoses and treatments are added sequentially
                }
                records.put(record.getPatientID(), record);
            }
        } catch (IOException e) {
            System.out.println("Error loading medical records");
        }
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("medical_records.txt"))) {
            for (MedicalRecord record : records.values()) {
                bw.write(record.getPatientID() + "," + 
                         record.getName() + "," + 
                         record.getDateOfBirth() + "," + 
                         record.getGender() + "," + 
                         record.getContactNumber() + "," + 
                         record.getEmailAddress() + "," + 
                         record.getBloodType());
                for (String diagnosis : record.getPastDiagnoses()) {
                    bw.write("," + diagnosis); // Write past diagnoses
                }
                for (String treatment : record.getPastTreatments()) {
                    bw.write("," + treatment); // Write past treatments
                }
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving medical records");
        }
    }
}
