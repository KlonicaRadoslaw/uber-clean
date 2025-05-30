package studies.uber_clean.vehicles.domain;

import java.util.HashMap;
import java.util.Map;

// Tydzień 4, Wzorzec FlyWeight 1
/**
 * Fabryka pojazdów stosująca wzorzec Flyweight.
 * Zapewnia współdzielenie obiektów pojazdów według modelu i producenta.
 */
public class VehicleFlyweightFactory {
    // Tydzień 9, Magic numbers
    private static final int MANUFACTURING_YEAR_EXAMPLE = 2024;
    private static final int SEATS_EXAMPLE = 4;
    private static final Map<String, Vehicle> vehicleCache = new HashMap<>();

    /**
     * Pobiera istniejący pojazd lub tworzy nowy, jeśli jeszcze nie istnieje.
     * @param manufacturer Producent pojazdu.
     * @param model Model pojazdu.
     * @return Współdzielony obiekt Vehicle.
     */
    public static Vehicle getVehicle(String manufacturer, String model) {
        String key = manufacturer + "_" + model;

        // Sprawdzenie czy pojazd już istnieje w cache
        if (!vehicleCache.containsKey(key)) {
            Vehicle vehicle = new Car(manufacturer, model, "UNKNOWN_VIN", MANUFACTURING_YEAR_EXAMPLE, SEATS_EXAMPLE); // Tworzymy domyślny pojazd
            // Koniec, Tydzień 9, Magic numbers
            vehicleCache.put(key, vehicle);
        }
        return vehicleCache.get(key);
    }
}
// Koniec, Tydzień 4, Wzorzec FlyWeight 1