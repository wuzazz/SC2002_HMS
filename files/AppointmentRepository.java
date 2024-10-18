import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class AppointmentRepository {
    private List<Appointment> appointments;

    public AppointmentRepository() {
        this.appointments = new ArrayList<>();
        loadData(); // Load existing appointments
    }

    // Adds a new appointment
    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        saveData(); // Save to file
    }

    // Retrieves all appointments for a doctor or patient
    public List<Appointment> getAppointmentsForUser(String userId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment appt : appointments) {
            if (appt.getUserId().equals(userId)) {
                result.add(appt);
            }
        }
        return result;
    }

    // Load appointments from file
    private void loadData() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("appointments.dat"))) {
            appointments = (List<Appointment>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading appointment data.");
        }
    }

    // Save appointments to file
    private void saveData() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("appointments.dat"))) {
            oos.writeObject(appointments);
        } catch (IOException e) {
            System.out.println("Error saving appointment data.");
        }
    }
}
