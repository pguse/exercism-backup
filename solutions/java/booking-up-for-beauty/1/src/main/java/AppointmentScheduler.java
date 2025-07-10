import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalTime;

class AppointmentScheduler {
    public LocalDateTime schedule(String appointmentDateDescription) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(appointmentDateDescription, formatter);
        return dateTime;
    }

    public boolean hasPassed(LocalDateTime appointmentDate) {
        return appointmentDate.isBefore(LocalDateTime.now());
    }

    public boolean isAfternoonAppointment(LocalDateTime appointmentDate) {
        LocalTime time = appointmentDate.toLocalTime();
        return ( (time.isAfter(LocalTime.of(12,0)) || time.equals(LocalTime.of(12,0))) && time.isBefore(LocalTime.of(18,0)) );
    }

    public String getDescription(LocalDateTime appointmentDate) {
        DateTimeFormatter printer = DateTimeFormatter.ofPattern("EEEE, MMMM d, yyyy, 'at' h:mm a");
        return "You have an appointment on " + printer.format(appointmentDate) + ".";
    }

    public LocalDate getAnniversaryDate() {
        LocalDate date = LocalDate.now();
        return LocalDate.of(date.getYear(), 9, 15);
    }
}
