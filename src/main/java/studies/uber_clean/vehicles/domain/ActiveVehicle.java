package studies.uber_clean.vehicles.domain;

import java.util.HashMap;
import java.util.Map;

// Tydzień 1, Wzorzec Prototype 2
// Klasa służąca do przechowywania informacji o aktywnych pojazdach (takie które są przypisane do kierowcy)
public class ActiveVehicle {
    private static ActiveVehicle instance;
    private final Map<Long, Vehicle> activeVehicles;

    private ActiveVehicle() {
        activeVehicles = new HashMap<>();
    }

    public static synchronized ActiveVehicle getInstance() {
        if (instance == null) {
            instance = new ActiveVehicle();
        }
        return instance;
    }

    public void addVehicle(Vehicle vehicle) {
        activeVehicles.put(vehicle.getVehicleId(), vehicle);
    }

    public Vehicle getVehicle(Long vehicleId) {
        return activeVehicles.get(vehicleId);
    }

    public Map<Long, Vehicle> getAllActiveVehicles() {
        return activeVehicles;
    }

    public void removeVehicle(Long id) {
        activeVehicles.remove(id);
    }
}
// Koniec, Tydzień 1, Wzorzec Prototype
