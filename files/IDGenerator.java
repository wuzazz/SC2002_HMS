package repositories;
import java.util.UUID;

public class IDGenerator {
    // Generates a unique ID
    public static String generateID() {
        return UUID.randomUUID().toString();
    }
}
