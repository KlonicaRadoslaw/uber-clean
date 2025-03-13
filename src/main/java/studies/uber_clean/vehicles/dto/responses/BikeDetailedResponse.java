package studies.uber_clean.vehicles.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikeDetailedResponse {
    public Long bikeId;
    protected String manufacturer;
    protected String model;
    private boolean isAssigned;
    public boolean haveBasket;

    public BikeDetailedResponse(Long bikeId, String manufacturer, String model, boolean isAssigned, boolean haveBasket) {
        this.bikeId = bikeId;
        this.manufacturer = manufacturer;
        this.model = model;
        this.isAssigned = isAssigned;
        this.haveBasket = haveBasket;
    }
}
