package services;

import models.Appointment;
import repository.AppointmentRepository;

import java.util.List;

public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService() {
        this.appointmentRepository = new AppointmentRepository();
    }

    // Schedule a new appointment
    public boolean scheduleAppointment(Appointment appointment) {
        // Check for conflicts
        if (appointmentRepository.isSlotAvailable(appointment.getDoctorId(), appointment.getAppointmentDate(), appointment.getAppointmentTime())) {
            appointmentRepository.save(appointment);
            return true;
        }
        return false;
    }

    // Reschedule an existing appointment
    public boolean rescheduleAppointment(String appointmentId, String newDate, String newTime) {
        Appointment appointment = appointmentRepository.findById(appointmentId);
        if (appointment != null && appointmentRepository.isSlotAvailable(appointment.getDoctorId(), newDate, newTime)) {
            appointment.updateStatus("Rescheduled");
            appointmentRepository.updateAppointmentDateTime(appointmentId, newDate, newTime);
            return true;
        }
        return false;
    }

    // Cancel an appointment
    public boolean cancelAppointment(String appointmentId) {
        Appointment appointment = appointmentRepository.findById(appointmentId);
        if (appointment != null && !appointment.getStatus().equalsIgnoreCase("Cancelled")) {
            appointment.updateStatus("Cancelled");
            appointmentRepository.update(appointment);
            return true;
        }
        return false;
    }

    // Get available appointment slots for a doctor
    public List<Appointment> getAvailableSlots(String doctorId, String date) {
        return appointmentRepository.getAvailableSlots(doctorId, date);
    }

    // Get appointments by doctor
    public List<Appointment> getAppointmentsByDoctor(String doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    // Get appointments by patient
    public List<Appointment> getAppointmentsByPatient(String patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    // Update appointment status
    public void updateAppointmentStatus(String appointmentId, String status) {
        Appointment appointment = appointmentRepository.findById(appointmentId);
        if (appointment != null) {
            appointment.updateStatus(status);
            appointmentRepository.update(appointment);
        }
    }
}
