package repositories;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class InventoryRepository {
    private Map<String, Integer> inventory; // Medication ID, Stock Level

    public InventoryRepository() {
        this.inventory = new HashMap<>();
        loadData();
    }

    // Updates the stock level for a specific medication
    public void updateStock(String medicationId, int stock) {
        inventory.put(medicationId, stock);
        saveData();
    }

    // Retrieves the stock level for a medication
    public int getStock(String medicationId) {
        return inventory.getOrDefault(medicationId, 0);
    }

    // Load inventory from file
    private void loadData() {
        try (BufferedReader br = new BufferedReader(new FileReader("inventory.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] item = line.split(",");
                inventory.put(item[0], Integer.parseInt(item[1])); // medicationId, stock level
            }
        } catch (IOException e) {
            System.out.println("Error loading inventory data.");
        }
    }

    // Save inventory to file
    private void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("inventory.txt"))) {
            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                bw.write(entry.getKey() + "," + entry.getValue());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving inventory data.");
        }
    }
}
