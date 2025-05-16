package studies.uber_clean.payments.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Tydzień 13, Unit tests 2
class PaymentFacadeTest {

    // Mock dla interfejsu PaymentProcessor
    class MockPaymentProcessor implements PaymentProcessor {
        boolean expectedResult;
        String lastAccountNumber;
        double lastAmount;

        public MockPaymentProcessor(boolean expectedResult) {
            this.expectedResult = expectedResult;
        }

        @Override
        public boolean pay(String accountNumber, double amount) {
            this.lastAccountNumber = accountNumber;
            this.lastAmount = amount;
            return expectedResult;
        }
    }

    @Test
    void shouldReturnTrueWhenPaymentSucceeds() {
        MockPaymentProcessor mockProcessor = new MockPaymentProcessor(true);
        PaymentFacade facade = new PaymentFacade(mockProcessor);

        boolean result = facade.processPayment("123456", 100.0);

        assertTrue(result);
        assertEquals("123456", mockProcessor.lastAccountNumber);
        assertEquals(100.0, mockProcessor.lastAmount);
    }

    @Test
    void shouldReturnFalseWhenPaymentFails() {
        MockPaymentProcessor mockProcessor = new MockPaymentProcessor(false);
        PaymentFacade facade = new PaymentFacade(mockProcessor);

        boolean result = facade.processPayment("987654", 50.0);

        assertFalse(result);
        assertEquals("987654", mockProcessor.lastAccountNumber);
        assertEquals(50.0, mockProcessor.lastAmount);
    }

    @Test
    void shouldHandleZeroAmount() {
        MockPaymentProcessor mockProcessor = new MockPaymentProcessor(true);
        PaymentFacade facade = new PaymentFacade(mockProcessor);

        boolean result = facade.processPayment("000000", 0.0);

        assertTrue(result);  // zakładamy, że zero też jest akceptowalne
        assertEquals(0.0, mockProcessor.lastAmount);
    }

    @Test
    void shouldHandleNegativeAmount() {
        MockPaymentProcessor mockProcessor = new MockPaymentProcessor(false); // np. odrzuca płatności ujemne
        PaymentFacade facade = new PaymentFacade(mockProcessor);

        boolean result = facade.processPayment("999999", -100.0);

        assertFalse(result);
        assertEquals(-100.0, mockProcessor.lastAmount);
    }

    @Test
    void shouldProcessLargeAmount() {
        MockPaymentProcessor mockProcessor = new MockPaymentProcessor(true);
        PaymentFacade facade = new PaymentFacade(mockProcessor);

        boolean result = facade.processPayment("888888", 1_000_000.0);

        assertTrue(result);
        assertEquals(1_000_000.0, mockProcessor.lastAmount);
    }
}
// Koniec, Tydzień 13, Unit tests 2