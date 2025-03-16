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
}