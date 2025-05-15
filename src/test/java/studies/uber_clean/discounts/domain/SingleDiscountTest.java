package studies.uber_clean.discounts.domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

// Tydzień 13, Testy jednostkowe 1
class SingleDiscountTest {

    @Test
    void applyPercentageDiscount_shouldReducePriceByPercentage() {
        // Test sprawdza, czy zniżka procentowa poprawnie zmniejsza cenę o zadany procent
        SingleDiscount discount = new SingleDiscount("10% off", BigDecimal.valueOf(10), true);
        BigDecimal price = BigDecimal.valueOf(200);
        BigDecimal expected = BigDecimal.valueOf(180); // 200 - 10% = 180
        assertEquals(0, expected.compareTo(discount.applyDiscount(price)));
    }

    @Test
    void applyFixedDiscount_shouldReducePriceByFixedAmount() {
        // Test sprawdza, czy zniżka kwotowa odejmuje odpowiednią wartość od ceny
        SingleDiscount discount = new SingleDiscount("20 off", BigDecimal.valueOf(20), false);
        BigDecimal price = BigDecimal.valueOf(100);
        BigDecimal expected = BigDecimal.valueOf(80);
        assertEquals(0, expected.compareTo(discount.applyDiscount(price)));
    }

    @Test
    void applyFixedDiscount_shouldNotGoBelowZero() {
        // Testuje, czy zniżka kwotowa nie spowoduje, że cena stanie się ujemna (minimalna cena to 0)
        SingleDiscount discount = new SingleDiscount("50 off", BigDecimal.valueOf(50), false);
        BigDecimal price = BigDecimal.valueOf(30);
        BigDecimal expected = BigDecimal.ZERO;
        assertEquals(0, expected.compareTo(discount.applyDiscount(price)));
    }

    @Test
    void isPercentage_shouldReturnTrueForPercentageDiscount() {
        // Testuje, czy metoda isPercentage poprawnie zwraca true dla zniżek procentowych
        SingleDiscount discount = new SingleDiscount("15% off", BigDecimal.valueOf(15), true);
        assertTrue(discount.isPercentage());
    }

    @Test
    void getters_shouldReturnCorrectValues() {
        // Testuje poprawność getterów: nazwy, wartości zniżki oraz typu (procentowa/kwotowa)
        SingleDiscount discount = new SingleDiscount("Flat discount", BigDecimal.valueOf(25), false);
        assertEquals("Flat discount", discount.getName());
        assertEquals(0, BigDecimal.valueOf(25).compareTo(discount.getDiscountAmount()));
        assertFalse(discount.isPercentage());
    }
}
// Koniec, Tydzień 13, Testy jednostkowe 1
