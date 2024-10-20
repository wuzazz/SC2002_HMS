package Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.*;

public class InventoryRepository {
    private Map<String, Medication> inventory; // Maps medication name to Medication object

    public InventoryRepository() {
        this.inventory = new HashMap<>();
        loadData(); // Load inventory data from the file
    }

    public void addMedication(String name, int currentStock, int lowStockAlertLevel) {
        Medication medication = new Medication(name, currentStock, lowStockAlertLevel);
        inventory.put(name, medication);
        saveData();
    }

    public Medication findByName(String name) {
        return inventory.get(name); // Return the Medication object if found, otherwise null
    }

    public void updateStock(String name, int quantity) {
        Medication medication = findByName(name);
        if (medication != null) {
            medication.updateStock(quantity); // Update the stock level
            saveData(); // Save the updated inventory data to the file
        }
    }

    public void removeMedication(String name) {
        Medication medication = findByName(name);
        if (medication != null) {
            inventory.remove(name); // Remove the medication from the inventory
            saveData(); // Save the updated inventory data to the file
            System.out.println("Medication " + medication.getName() + " removed successfully.");
        } else {
            System.out.println("Medication not found. Removal failed.");
        }
    }

    public void approveReplenishmentRequest(String medicationName) {
        Medication medication = findByName(medicationName);
        if (medication != null) {
            List<Integer> requests = medication.getReplenishmentRequests();
            if (!requests.isEmpty()) {
                // Assuming we only want to approve the first request
                int quantity = requests.get(0); // Get the first requested quantity
                medication.updateStock(quantity); // Update stock with the requested quantity
                System.out.println("Approved replenishment for " + medicationName + ": " + quantity + " units added.");
                // Remove the request
                medication.getReplenishmentRequests().remove(Integer.valueOf(quantity));
            } else {
                System.out.println("No replenishment requests found for " + medicationName);
            }
        } else {
            System.out.println("Medication not found: " + medicationName);
        }
    }
    
    // New method to get all medications
    public List<Medication> getAllMedications() {
        return new ArrayList<>(inventory.values()); // Return a list of all Medication objects
    }

    public void reviewReplenishmentRequests() {
        for (Medication medication : getAllMedications()) { // Use the newly added method
            List<Integer> requests = medication.getReplenishmentRequests();
            if (!requests.isEmpty()) {
                System.out.println("Medication: " + medication.getName() + " has the following requests: " + requests);
            }
        }
    }

    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] medicationData = line.split(",");
                Medication medication = new Medication(medicationData[0], Integer.parseInt(medicationData[1]), Integer.parseInt(medicationData[2]));
                inventory.put(medication.getName(), medication);
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory data");
        }
    }

    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventory.txt"))) {
            for (Medication medication : inventory.values()) {
                bw.write(medication.getName() + "," + 
                         medication.getCurrentStock() + "," + 
                         medication.getLowStockAlertLevel());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory data");
        }
    }
}
