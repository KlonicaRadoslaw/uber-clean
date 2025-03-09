package studies.uber_clean.vehicles;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import studies.uber_clean.users.domain.Driver;
import studies.uber_clean.users.domain.User;
import studies.uber_clean.users.domain.UserRepository;
import studies.uber_clean.vehicles.domain.ActiveVehicle;
import studies.uber_clean.vehicles.domain.Vehicle;
import studies.uber_clean.vehicles.domain.VehicleRepository;
import java.util.Map;

@Component
public class ActiveVehicleList {
    private final ActiveVehicle activeVehicles = ActiveVehicle.getInstance();
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    public ActiveVehicleList(UserRepository userRepository, VehicleRepository vehicleRepository) {
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public ResponseEntity<String> assignVehicle(Long userId, Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        if (user instanceof Driver && !vehicle.isAssigned()) {
            ((Driver) user).setAssignedVehicle(vehicle);
            vehicle.setAssigned(true);
            activeVehicles.addVehicle(vehicle);
        }

        vehicleRepository.save(vehicle);
        userRepository.save(user);

        return ResponseEntity.ok("Successful assignment");
    }

    public ResponseEntity<String> unassignVehicle(Long userId, Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow();
        User user = userRepository.findById(userId).orElseThrow();

        if (user instanceof Driver && vehicle.isAssigned()) {
            ((Driver) user).setAssignedVehicle(null);
            vehicle.setAssigned(false);
            activeVehicles.removeVehicle(vehicleId);
        }

        vehicleRepository.save(vehicle);
        userRepository.save(user);

        return ResponseEntity.ok("Successful unassignment");
    }

    public Vehicle getActiveVehicle(Long id) {
        return activeVehicles.getVehicle(id);
    }

    public Map<Long, Vehicle> getActiveVehicles() {
        return activeVehicles.getAllActiveVehicles();
    }


}
