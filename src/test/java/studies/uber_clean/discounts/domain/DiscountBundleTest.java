package studies.uber_clean.discounts.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Tydzień 13, Testy jednostkowe 1
class DiscountBundleTest {

    private DiscountBundle discountBundle;
    private SingleDiscount discount1;
    private SingleDiscount discount2;

    @BeforeEach
    void setUp() {
        // Inicjalizacja DiscountBundle oraz dwóch "mocków" SingleDiscount przed każdym testem
        discountBundle = new DiscountBundle("TestBundle");
        discount1 = mock(SingleDiscount.class);
        discount2 = mock(SingleDiscount.class);
    }

    @Test
    void shouldAddDiscountsToBundle() {
        // Testuje czy można poprawnie dodać zniżki do bundle
        discountBundle.addDiscount(discount1);
        discountBundle.addDiscount(discount2);

        // Iterujemy po bundle i zliczamy elementy, powinno ich być 2
        DiscountIterator iterator = discountBundle.createIterator();
        int count = 0;
        while (iterator.hasNext()) {
            iterator.next();
            count++;
        }
        assertEquals(2, count, "Powinno być dokładnie 2 zniżki w bundle");
    }

    @Test
    void shouldRemoveDiscountFromBundle() {
        // Testuje usuwanie zniżki z bundle
        discountBundle.addDiscount(discount1);
        discountBundle.addDiscount(discount2);

        discountBundle.removeDiscount(discount1);

        // Sprawdzamy, czy zniżka discount1 została usunięta, a discount2 pozostała
        DiscountIterator iterator = discountBundle.createIterator();
        List<DiscountComponent> remaining = new ArrayList<>();
        while (iterator.hasNext()) {
            remaining.add(iterator.next());
        }
        assertFalse(remaining.contains(discount1), "discount1 powinien zostać usunięty");
        assertTrue(remaining.contains(discount2), "discount2 powinien pozostać");
    }

    @Test
    void shouldApplyAllDiscountsSequentially() {
        // Testuje czy zniżki są stosowane jedna po drugiej na cenę
        discountBundle.addDiscount(discount1);
        discountBundle.addDiscount(discount2);

        BigDecimal initialPrice = new BigDecimal("100.00");

        // Definiujemy zachowanie mocków: discount1 zmniejsza cenę do 90, discount2 do 80
        when(discount1.applyDiscount(initialPrice)).thenReturn(new BigDecimal("90.00"));
        when(discount2.applyDiscount(new BigDecimal("90.00"))).thenReturn(new BigDecimal("80.00"));

        BigDecimal finalPrice = discountBundle.applyDiscount(initialPrice);

        // Oczekujemy ceny 80 po zastosowaniu obu zniżek
        assertEquals(new BigDecimal("80.00"), finalPrice, "Końcowa cena powinna wynosić 80.00");

        // Weryfikujemy, czy metody applyDiscount na mockach zostały wywołane z odpowiednimi argumentami
        verify(discount1).applyDiscount(initialPrice);
        verify(discount2).applyDiscount(new BigDecimal("90.00"));
    }

    @Test
    void shouldSaveAndRestoreStateUsingMemento() {
        // Testuje mechanizm zapisywania i przywracania stanu bundle (wzorzec Memento)
        discountBundle.addDiscount(discount1);
        discountBundle.addDiscount(discount2);

        // Zapisujemy stan bundle z dwoma zniżkami
        DiscountBundleMemento savedState = discountBundle.saveState();

        // Usuwamy jedną zniżkę, więc w bundle pozostaje tylko jedna
        discountBundle.removeDiscount(discount1);

        DiscountIterator iterator = discountBundle.createIterator();
        List<DiscountComponent> current = new ArrayList<>();
        while (iterator.hasNext()) {
            current.add(iterator.next());
        }
        assertEquals(1, current.size(), "Po usunięciu powinna zostać jedna zniżka");
        assertFalse(current.contains(discount1), "Usunięta zniżka nie powinna się pojawiać");

        // Przywracamy poprzedni stan bundle
        discountBundle.restoreState(savedState);

        iterator = discountBundle.createIterator();
        current.clear();
        while (iterator.hasNext()) {
            current.add(iterator.next());
        }

        // Po przywróceniu powinny być obie zniżki jak na początku
        assertEquals(2, current.size(), "Po przywróceniu powinny być dwie zniżki");
        assertTrue(current.contains(discount1), "discount1 powinien być obecny po przywróceniu");
        assertTrue(current.contains(discount2), "discount2 powinien być obecny po przywróceniu");
    }

    @Test
    void shouldReturnCorrectBundleName() {
        // Testuje getter na nazwę bundle
        assertEquals("TestBundle", discountBundle.getBundleName(), "Nazwa bundle powinna być 'TestBundle'");
    }
}
// Koniec, Tydzień 13, Testy jednostkowe 1
