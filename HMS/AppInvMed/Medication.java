package Inventory;

import java.util.ArrayList;
import java.util.List;

public class Medication {
    private String name;
    private int currentStock;
    private int lowStockAlertLevel;
    private List<Integer> replenishmentRequests; // Store requested amounts

    public Medication(String name, int currentStock, int lowStockAlertLevel) {
        this.name = name;
        this.currentStock = currentStock;
        this.lowStockAlertLevel = lowStockAlertLevel;
        this.replenishmentRequests = new ArrayList<>(); // Initialize the requests list
    }

    public String getName() {
        return name;
    }

    public int getCurrentStock() {
        return currentStock;
    }

    public int getLowStockAlertLevel() {
        return lowStockAlertLevel;
    }

    public void updateStock(int quantity) {
        this.currentStock += quantity; // Update stock level by adding the quantity
    }

    public void submitReplenishmentRequest(int quantity) {
        if (currentStock < lowStockAlertLevel) {
            replenishmentRequests.add(quantity); // Add the requested amount to the list
            System.out.println("Replenishment request submitted for medication: " + name + " for amount: " + quantity);
        } else {
            System.out.println("Stock level is sufficient for medication: " + name);
        }
    }

    public List<Integer> getReplenishmentRequests() {
        return replenishmentRequests; // Getter for requests
    }

    public void clearReplenishmentRequests() {
        replenishmentRequests.clear(); // Clear requests after processing
    }
}
