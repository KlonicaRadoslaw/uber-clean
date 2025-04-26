package studies.uber_clean.rides.domain;

import java.util.HashMap;
import java.util.Map;

// Tydzień 8, Wzorzec Liskov 3
// LSP - Klasa pochodna
public class VIPRideSession extends RideSession {

    private final Map<Long, String> vipNotes = new HashMap<>();

    public void addVipNote(Long orderId, String note) {
        vipNotes.put(orderId, note);
    }

    public String getVipNote(Long orderId) {
        return vipNotes.get(orderId);
    }
}
// Koniec, Tydzień 8, Wzorzec Liskov 3