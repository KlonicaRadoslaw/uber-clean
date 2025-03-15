package studies.uber_clean.routes.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SimpleRoute extends Route {

    private String startPoint;
    private String endPoint;

    public SimpleRoute () {}

    public SimpleRoute(String startPoint, String endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    @Override
    public void displayRoute() {
        System.out.println("Simple route from " + startPoint + " to " + endPoint);
    }
}