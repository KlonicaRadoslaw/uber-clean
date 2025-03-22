package studies.uber_clean.vehicles;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studies.uber_clean.vehicles.domain.Vehicle;
import studies.uber_clean.vehicles.domain.VehicleFacade;
import studies.uber_clean.vehicles.dto.requests.CreateVehicleRequest;
import studies.uber_clean.vehicles.dto.responses.BikeDetailedResponse;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
    private final VehicleFacade vehicleFacade;
    private final ActiveVehicleList activeVehicleList;

    public VehicleController(VehicleFacade vehicleFacade, ActiveVehicleList activeVehicleList) {
        this.vehicleFacade = vehicleFacade;
        this.activeVehicleList = activeVehicleList;
    }

    @PostMapping
    public Vehicle addVehicle(@RequestBody CreateVehicleRequest payload, String type) {
        return vehicleFacade.addVehicle(payload, type);
    }

    @PostMapping("/add-car")
    public Vehicle addCar(@RequestBody CreateVehicleRequest payload) {
        return vehicleFacade.addCar(payload);
    }

    @PostMapping("/add-vehicle-fly-weight")
    public Vehicle addVehicleWithFlyWeight(@RequestBody CreateVehicleRequest payload, String type) {
        return vehicleFacade.addVehicleWithFlyWeight(payload, type);
    }

    @PostMapping("/add-bike")
    public BikeDetailedResponse addBike(@RequestBody CreateVehicleRequest payload) {
        return vehicleFacade.addBike(payload);
    }

    @PostMapping("/add-scooter")
    public Vehicle addScooter(@RequestBody CreateVehicleRequest payload) {
        return vehicleFacade.addScooter(payload);
    }

    @GetMapping("/{vehicleId}")
    public Vehicle getVehicle(@PathVariable Long vehicleId) {
        return vehicleFacade.getVehicle(vehicleId);
    }

    @GetMapping
    public List<Vehicle> getVehicles() {
        return vehicleFacade.getAllVehicles();
    }

    @PostMapping("/{vehicleId}/users/{userId}/assign-vehicle")
    public ResponseEntity<String> assignVehicle(@PathVariable Long userId, @PathVariable Long vehicleId) {
        return activeVehicleList.assignVehicle(userId, vehicleId);
    }

    @PostMapping("/{vehicleId}/users/{userId}/unassign-vehicle")
    public ResponseEntity<String> unassignVehicle(@PathVariable Long userId, @PathVariable Long vehicleId) {
        return activeVehicleList.unassignVehicle(userId, vehicleId);
    }

    @GetMapping("/get-active-vehicles")
    public Map<Long, Vehicle> getActiveVehicles() {
        return activeVehicleList.getActiveVehicles();
    }

    @GetMapping("/get-active-vehicles/{vehicleId}")
    public Vehicle getActiveVehicle(@PathVariable Long vehicleId) {
        return activeVehicleList.getActiveVehicle(vehicleId);
    }

    @PostMapping("/bikes/{bikeId}")
    public BikeDetailedResponse cloneBikeOrScooter(@PathVariable Long bikeId) {
        return vehicleFacade.cloneBike(bikeId);
    }

    // Tydzień 5, Wzorzec Command 1
    @PostMapping("/{vehicleId}/assign")
    public void assignVehicle(@PathVariable Long vehicleId) {
        vehicleFacade.assignVehicle(vehicleId);
    }

    @PostMapping("/{vehicleId}/unassign")
    public void unassignVehicle(@PathVariable Long vehicleId) {
        vehicleFacade.unassignVehicle(vehicleId);
    }

    @GetMapping("/history")
    public void getCommandHistory() {
        vehicleFacade.showCommandHistory();
    }
    // Koniec, Tydzień 5, Wzorzec Command 1

    @GetMapping("/filter")
    public List<Vehicle> filterVehicles(@RequestParam String query) {
        return vehicleFacade.filterVehicles(query);
    }
}
