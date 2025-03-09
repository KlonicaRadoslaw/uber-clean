package studies.uber_clean.vehicles.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateVehicleRequest {
    public String manufacturer;
    public String model;
    public boolean haveBasket = false;
    public int seats = 0;
    public int manufacturingYear = 0;
    public String vin = "";
    public int maxSpeed = 0;
    public int maxRangeOnSingleCharge = 0;
}
