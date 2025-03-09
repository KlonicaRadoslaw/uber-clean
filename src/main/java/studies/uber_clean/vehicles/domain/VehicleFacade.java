package studies.uber_clean.vehicles.domain;

import studies.uber_clean.vehicles.dto.requests.CreateVehicleRequest;

import java.util.List;

// Tydzień 4, Wzorzec Facade 3
public class VehicleFacade {
    private final VehicleRepository vehicleRepository;

    public VehicleFacade(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(CreateVehicleRequest createVehicleRequest, String type) {
        Vehicle vehicle;
        // Tydzień 1, Wzorzec Factory 3
        // Wytwarzanie pojazdów za pomocą fabryki zależnie od typu
        switch (type.toLowerCase()) {
            case "car" -> vehicle = new Car(createVehicleRequest.manufacturer, createVehicleRequest.model, createVehicleRequest.vin, createVehicleRequest.manufacturingYear, createVehicleRequest.seats);
            case "bike" -> vehicle = new Bike(createVehicleRequest.manufacturer, createVehicleRequest.model, createVehicleRequest.haveBasket);
            case "scooter" -> vehicle = new Scooter(createVehicleRequest.manufacturer, createVehicleRequest.model, createVehicleRequest.maxSpeed, createVehicleRequest.maxRangeOnSingleCharge);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        // Koniec, Tydzień 1, Wzorzec Factory 3

        return vehicleRepository.save(vehicle);
    }

    public Vehicle addCar(CreateVehicleRequest createVehicleRequest) {
        Car car = new VehicleBuilder()
                .setManufacturer(createVehicleRequest.manufacturer)
                .setModel(createVehicleRequest.model)
                .buildCar(createVehicleRequest.vin, createVehicleRequest.manufacturingYear, createVehicleRequest.seats);

        return vehicleRepository.save(car);
    }

    public Vehicle addBike(CreateVehicleRequest createVehicleRequest) {
        Bike bike = new VehicleBuilder()
                .setManufacturer(createVehicleRequest.manufacturer)
                .setModel(createVehicleRequest.model)
                .buildBike(createVehicleRequest.haveBasket);

        return vehicleRepository.save(bike);
    }

    public Vehicle addScooter(CreateVehicleRequest createVehicleRequest) {
        Scooter scooter = new VehicleBuilder()
                .setManufacturer(createVehicleRequest.manufacturer)
                .setModel(createVehicleRequest.model)
                .buildScooter(createVehicleRequest.maxSpeed, createVehicleRequest.maxRangeOnSingleCharge);

        return vehicleRepository.save(scooter);
    }

    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).orElseThrow();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }
}
// Koniec, Tydzień 4, Wzorzec Facade 2