package studies.uber_clean.transport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studies.uber_clean.transport.domain.TransportFacade;

@RestController
@RequestMapping("/api/transport")
public class TransportController {

    private final TransportFacade transportFacade;

    @Autowired
    public TransportController(TransportFacade transportFacade) {
        this.transportFacade = transportFacade;
    }

    @PostMapping("/person")
    public ResponseEntity<String> bookPersonTransport(@RequestParam double amount,
                                                      @RequestParam String paymentType) {
        try {
            transportFacade.bookPersonTransport(amount, paymentType);
            return ResponseEntity.ok("Person transport booked successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/food")
    public ResponseEntity<String> bookFoodTransport(@RequestParam double amount,
                                                    @RequestParam String paymentType) {
        try {
            transportFacade.bookFoodTransport(amount, paymentType);
            return ResponseEntity.ok("Food transport booked successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    // Tydzień 4, Wzorzec Proxy 1
    /**
     * Endpoint rezerwacji transportu i płatności.
     * @param amount Kwota płatności.
     * @param paymentType Typ płatności ("card" lub "cash").
     * @return Komunikat o statusie transakcji.
     */
    @PostMapping("/book")
    public String bookTransport(@RequestParam double amount, @RequestParam String paymentType) {
        try {
            transportFacade.bookTransportWithProxy(amount, paymentType); // Rezerwacja transportu
            return "Rezerwacja transportu i płatność zakończone.";
        } catch (IllegalArgumentException e) {
            return "Błąd: " + e.getMessage(); // Obsługa błędu w przypadku niepoprawnej metody płatności
        }
    }
    // Koniec, Tydzień 4, Wzorzec Proxy 1
}