package studies.uber_clean.vehicles.domain;

// Tydzień 5, Wzorzec Command 1
/**
 * Konkretna komenda – zwalnia pojazd.
 */
public class UnassignVehicleCommand implements Command {
    private final Vehicle vehicle;

    public UnassignVehicleCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        if (vehicle.isAssigned()) {
            vehicle.setAssigned(false);
            System.out.println("Pojazd " + vehicle.getVehicleId() + " został zwolniony.");
        } else {
            System.out.println("Pojazd " + vehicle.getVehicleId() + " nie jest przypisany.");
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Command 1