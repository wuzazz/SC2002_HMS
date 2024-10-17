package services;

import models.Medication;
import repository.InventoryRepository;

import java.util.List;

public class InventoryService {

    private InventoryRepository inventoryRepository;

    public InventoryService() {
        this.inventoryRepository = new InventoryRepository();
    }

    // View all medications
    public List<Medication> viewAllMedications() {
        return inventoryRepository.findAll();
    }

    // Update medication stock
    public boolean updateMedicationStock(String medicationId, int newStock) {
        Medication medication = inventoryRepository.findById(medicationId);
        if (medication != null) {
            medication.updateStockLevel(newStock);
            inventoryRepository.update(medication);
            return true;
        }
        return false;
    }

    // Add new medication
    public void addMedication(Medication medication) {
        inventoryRepository.save(medication);
    }

    // Remove medication
    public void removeMedication(String medicationId) {
        inventoryRepository.delete(medicationId);
    }

    // Submit replenishment request
    public boolean submitReplenishmentRequest(String medicationId) {
        Medication medication = inventoryRepository.findById(medicationId);
        if (medication != null && medication.getStockLevel() < medication.getLowStockAlertLevel()) {
            // Logic to submit replenishment request
            // This could involve notifying administrators or adding to a request list
            // For simplicity, we'll assume it's handled here
            System.out.println("Replenishment request submitted for medication: " + medication.getName());
            return true;
        }
        return false;
    }

    // Get low stock medications
    public List<Medication> getLowStockMedications() {
        return inventoryRepository.findLowStockMedications();
    }
}
