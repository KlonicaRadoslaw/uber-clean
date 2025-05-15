package studies.uber_clean.discounts.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

// Tydzień 13, Testy jednostkowe 1
class DiscountInvokerTest {

    private DiscountInvoker invoker;
    private DiscountCommand mockCommand;
    private DiscountBundle discountBundle;

    @BeforeEach
    void setUp() {
        // Przygotowanie instancji DiscountInvoker i mocka DiscountCommand oraz utworzenie DiscountBundle z jedną zniżką
        invoker = new DiscountInvoker();
        mockCommand = mock(DiscountCommand.class);
        discountBundle = new DiscountBundle("Test Bundle");
        discountBundle.addDiscount(new SingleDiscount("Discount1", BigDecimal.TEN, false));
    }

    @Test
    void testExecuteCommandAddsToHistoryAndExecutes() {
        // Testuje, czy wywołanie executeCommand uruchamia komendę i dodaje ją do historii
        invoker.executeCommand(mockCommand, discountBundle);

        // Sprawdza, czy metoda execute() komendy została wywołana dokładnie raz
        verify(mockCommand, times(1)).execute();

        // Cofnięcie ostatniej komendy powinno wywołać metodę undo()
        invoker.undoLastCommand();
        verify(mockCommand, times(1)).undo();
    }

    @Test
    void testUndoLastCommandWhenHistoryIsEmptyDoesNothing() {
        // Testuje, że jeśli historia komend jest pusta, wywołanie undoLastCommand nie wywołuje undo na komendzie
        invoker.undoLastCommand();

        // verify sprawdza, że undo() na mocku nie było wywołane
        verify(mockCommand, never()).undo();
    }

    @Test
    void testUndoLastStateRestoresDiscountBundle() {
        // Testuje, czy mechanizm cofania stanu (memento) poprawnie przywraca poprzedni stan DiscountBundle

        // Zapisujemy stan bundle przed zmianą
        DiscountBundleMemento savedState = discountBundle.saveState();
        invoker.saveMemento(savedState);

        // Sprawdzamy, że zniżka faktycznie obniża cenę
        BigDecimal priceBeforeRemoval = discountBundle.applyDiscount(BigDecimal.valueOf(100));
        assertTrue(priceBeforeRemoval.compareTo(BigDecimal.valueOf(100)) < 0, "Cena powinna być mniejsza niż 100");

        // Usuwamy zniżkę z bundle
        SingleDiscount discountToRemove = (SingleDiscount) discountBundle.createIterator().next();
        discountBundle.removeDiscount(discountToRemove);

        // Po usunięciu zniżki cena powinna być równa 100 (brak zniżek)
        BigDecimal priceAfterRemoval = discountBundle.applyDiscount(BigDecimal.valueOf(100));
        assertEquals(BigDecimal.valueOf(100), priceAfterRemoval, "Cena po usunięciu zniżki powinna być 100");

        // Przywracamy wcześniejszy stan zniżek
        invoker.undoLastState(discountBundle);

        // Cena po przywróceniu stanu powinna być znowu mniejsza niż 100 (zniżka przywrócona)
        BigDecimal priceAfterRestore = discountBundle.applyDiscount(BigDecimal.valueOf(100));
        assertTrue(priceAfterRestore.compareTo(BigDecimal.valueOf(100)) < 0, "Cena po przywróceniu zniżki powinna być mniejsza niż 100");
    }


    @Test
    void testUndoAllCommandsClearsHistory() {
        // Testuje czy metoda undoAllCommands cofa wszystkie wykonane komendy i czy historia komend jest wtedy pusta
        invoker.executeCommand(mockCommand, discountBundle);
        invoker.executeCommand(mockCommand, discountBundle);

        invoker.undoAllCommands();

        // Weryfikujemy, że undo() zostało wywołane dokładnie dwa razy (dla obu komend)
        verify(mockCommand, times(2)).undo();

        // Po wyczyszczeniu historii kolejne wywołanie undoLastCommand nie powinno wywołać undo()
        invoker.undoLastCommand();
        verify(mockCommand, times(2)).undo();
    }

    @Test
    void testSaveMementoAddsToHistory() {
        // Testuje, czy metoda saveMemento poprawnie dodaje stan do historii i czy undoLastState potrafi ten stan przywrócić

        DiscountBundleMemento memento = discountBundle.saveState();
        invoker.saveMemento(memento);

        // Usuwamy zniżkę z bundle, aby stan się zmienił
        discountBundle.removeDiscount((SingleDiscount) discountBundle.createIterator().next());

        // Przywracamy ostatni zapisany stan zniżek
        invoker.undoLastState(discountBundle);

        // Sprawdzamy, że cena po przywróceniu stanu jest niższa niż cena bez zniżek (czyli zniżka została przywrócona)
        BigDecimal discountedPrice = discountBundle.applyDiscount(BigDecimal.valueOf(100));
        assertTrue(discountedPrice.compareTo(BigDecimal.valueOf(100)) < 0);
    }
}
// Koniec, Tydzień 13, Testy jednostkowe 1
