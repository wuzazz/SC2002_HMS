package services;

import models.MedicalRecord;
import repository.MedicalRecordRepository;

public class MedicalRecordService {

    private MedicalRecordRepository medicalRecordRepository;

    public MedicalRecordService() {
        this.medicalRecordRepository = new MedicalRecordRepository();
    }

    // Retrieve medical record by patient ID
    public MedicalRecord getMedicalRecordByPatientId(String patientId) {
        return medicalRecordRepository.findByPatientId(patientId);
    }

    // Update medical record with new diagnosis and treatment
    public void updateMedicalRecord(String patientId, String diagnosis, String treatment) {
        MedicalRecord medicalRecord = medicalRecordRepository.findByPatientId(patientId);
        if (medicalRecord != null) {
            medicalRecord.addDiagnosis(diagnosis);
            medicalRecord.addTreatment(treatment);
            medicalRecordRepository.update(medicalRecord);
        }
    }
}
