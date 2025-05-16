package studies.uber_clean.users.domain;

import org.junit.jupiter.api.Test;
import studies.uber_clean.loyaltyProgram.domain.LoyaltyVisitor;
import studies.uber_clean.loyaltyProgram.domain.VisitableUser;


import static org.junit.jupiter.api.Assertions.*;

// Tydzień 13, Unit tests 2
class CustomerTest {

    static class TestVisitor implements LoyaltyVisitor {
        boolean customerVisited = false;
        boolean driverVisited = false;

        @Override
        public void visit(Customer customer) {
            customerVisited = true;
        }

        @Override
        public void visit(Driver driver) {
            driverVisited = true;
        }
    }

    @Test
    void shouldCreateCustomerCorrectly() {
        Customer customer = new Customer("john@example.com", "pass123", "123456789", CustomerType.STANDARD);
        assertEquals("john@example.com", customer.getEmail());
    }

    @Test
    void shouldAcceptVisitorAndCallCustomerVisit() {
        Customer customer = new Customer("test@example.com", "123", "000000000", CustomerType.STANDARD);
        TestVisitor visitor = new TestVisitor();
        customer.accept(visitor);
        assertTrue(visitor.customerVisited);
        assertFalse(visitor.driverVisited);
    }

    @Test
    void shouldIdentifyCustomerType() {
        Customer customer = new Customer("x", "y", "z", CustomerType.PREMIUM);
        assertEquals(CustomerType.PREMIUM, customer.customerType);
    }

    @Test
    void shouldExtendUserAbstractClass() {
        Customer customer = new Customer();
        assertTrue(customer instanceof studies.uber_clean.users.domain.User);
    }

    @Test
    void shouldBeInstanceOfVisitableUser() {
        Customer customer = new Customer();
        assertTrue(customer instanceof VisitableUser);
    }
}
// Koniec, Tydzień 13, Unit tests 2