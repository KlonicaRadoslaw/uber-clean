package studies.uber_clean.payments;

import org.springframework.web.bind.annotation.*;
import studies.uber_clean.payments.domain.PaymentFacade;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentFacade paymentFacade;

    public PaymentController(PaymentFacade paymentFacade) {
        this.paymentFacade = paymentFacade;
    }

    @PostMapping
    public String processPayment(@RequestParam String accountNumber, @RequestParam double amount) {
        boolean result = paymentFacade.processPayment(accountNumber, amount);
        return result ? "Payment Successful" : "Payment Failed";
    }
}
