package studies.uber_clean.vehicles.domain;

// Tydzień 5, Wzorzec Command 1
/**
 * Konkretna komenda – przypisuje pojazd do użytkownika.
 */
public class AssignVehicleCommand implements Command {
    private final Vehicle vehicle;

    public AssignVehicleCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        if (!vehicle.isAssigned()) {
            vehicle.setAssigned(true);
            System.out.println("Pojazd " + vehicle.getVehicleId() + " został przypisany.");
        } else {
            System.out.println("Pojazd " + vehicle.getVehicleId() + " jest już przypisany.");
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Command 1