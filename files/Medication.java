package models;

public class Medication {
    private String medicationId;
    private String name;
    private int stockLevel;
    private int lowStockAlertLevel;

    public Medication(String medicationId, String name, int stockLevel, int lowStockAlertLevel) {
        this.medicationId = medicationId;
        this.name = name;
        this.stockLevel = stockLevel;
        this.lowStockAlertLevel = lowStockAlertLevel;
    }

    // Getters and Setters
    public String getMedicationId() {
        return medicationId;
    }

    public String getName() {
        return name;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public int getLowStockAlertLevel() {
        return lowStockAlertLevel;
    }

    // Method to update stock level
    public void updateStockLevel(int newStockLevel) {
        this.stockLevel = newStockLevel;
    }

    // Method to set low stock alert level
    public void setLowStockAlertLevel(int alertLevel) {
        this.lowStockAlertLevel = alertLevel;
    }
}
