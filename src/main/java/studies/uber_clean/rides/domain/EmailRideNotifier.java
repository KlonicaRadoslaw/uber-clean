package studies.uber_clean.rides.domain;

// Tydzień 8, Wzorzec Dependency Invertion 1
// DIP - Implementacja
public class EmailRideNotifier implements RideNotifier {
    @Override
    public void notifyCustomer(String message) {
        System.out.println("Sending EMAIL notification: " + message);
    }
}
// Koniec, Tydzień 8, Wzorzec Dependency Invertion 1