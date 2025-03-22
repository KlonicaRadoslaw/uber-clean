package studies.uber_clean.vehicles.domain;

import studies.uber_clean.vehicles.dto.requests.CreateVehicleRequest;
import studies.uber_clean.vehicles.dto.responses.BikeDetailedResponse;

import java.util.List;

// Tydzień 4, Wzorzec Facade 3
public class VehicleFacade {
    private final VehicleRepository vehicleRepository;
    // Tydzień 5, Wzorzec Command 1
    private final CommandInvoker commandInvoker = new CommandInvoker();
    // Koniec, Tydzień 5, Wzorzec Command 1

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

    // Tydzień 4, Wzorzec FlyWeight 1
    public Vehicle addVehicleWithFlyWeight(CreateVehicleRequest createVehicleRequest, String type) {
        Vehicle vehicle;

        switch (type.toLowerCase()) {
            case "car" -> vehicle = VehicleFlyweightFactory.getVehicle(createVehicleRequest.manufacturer, createVehicleRequest.model);
            case "bike" -> vehicle = new Bike(createVehicleRequest.manufacturer, createVehicleRequest.model, createVehicleRequest.haveBasket);
            case "scooter" -> vehicle = new Scooter(createVehicleRequest.manufacturer, createVehicleRequest.model, createVehicleRequest.maxSpeed, createVehicleRequest.maxRangeOnSingleCharge);
            default -> throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }

        return vehicleRepository.save(vehicle);
    }
    // Koniec, Tydzień 4, Wzorzec FlyWeight 1

    public Vehicle addCar(CreateVehicleRequest createVehicleRequest) {
        Car car = new VehicleBuilder()
                .setManufacturer(createVehicleRequest.manufacturer)
                .setModel(createVehicleRequest.model)
                .buildCar(createVehicleRequest.vin, createVehicleRequest.manufacturingYear, createVehicleRequest.seats);

        return vehicleRepository.save(car);
    }

    public BikeDetailedResponse addBike(CreateVehicleRequest createVehicleRequest) {
        Bike bike = new VehicleBuilder()
                .setManufacturer(createVehicleRequest.manufacturer)
                .setModel(createVehicleRequest.model)
                .buildBike(createVehicleRequest.haveBasket);

        return Bike.toDetailedResponse(vehicleRepository.save(bike));
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

    public BikeDetailedResponse cloneBike(Long vehicleId) {
        Vehicle vehicleToClone = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle not found"));
        Bike clonedVehicle;

        if (vehicleToClone instanceof Bike) {
            clonedVehicle = ((Bike) vehicleToClone).clone();
            vehicleRepository.save(clonedVehicle);
        } else throw new IllegalArgumentException("Unknown vehicle type: " + vehicleToClone.getClass().getSimpleName());

        return Bike.toDetailedResponse(clonedVehicle);
    }

    // Tydzień 5, Wzorzec Command 1
    public void assignVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow();
        Command assignCommand = new AssignVehicleCommand(vehicle);
        commandInvoker.executeCommand(assignCommand);
        vehicleRepository.save(vehicle);
    }

    public void unassignVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow();
        Command unassignCommand = new UnassignVehicleCommand(vehicle);
        commandInvoker.executeCommand(unassignCommand);
        vehicleRepository.save(vehicle);
    }

    public void showCommandHistory() {
        commandInvoker.showHistory();
    }
    // Koniec, Tydzień 5, Wzorzec Command 1
}
// Koniec, Tydzień 4, Wzorzec Facade 2