package studies.uber_clean.vehicles.domain;

import org.junit.jupiter.api.*;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

// Tydzień 13, Testy jednostkowe 1
class ActiveVehicleTest {

    // Stub klasy Vehicle – prosta implementacja abstrakcyjnej klasy Vehicle
    // używana do testów bez konieczności tworzenia pełnych obiektów Vehicle
    static class DummyVehicle extends Vehicle {
        private final Long id;

        public DummyVehicle(Long id) {
            this.id = id;
        }

        @Override
        public Long getVehicleId() {
            return id;
        }
    }

    private ActiveVehicle activeVehicle;
    private DummyVehicle vehicle1;
    private DummyVehicle vehicle2;

    @BeforeEach
    void setUp() {
        // Pobieramy singleton ActiveVehicle i czyścimy jego kolekcję pojazdów,
        // aby każdy test zaczynał się od pustej mapy aktywnych pojazdów
        activeVehicle = ActiveVehicle.getInstance();
        activeVehicle.getAllActiveVehicles().clear();

        // Tworzymy przykładowe dummy pojazdy do testów
        vehicle1 = new DummyVehicle(1L);
        vehicle2 = new DummyVehicle(2L);
    }

    @Test
    void testSingletonInstance() {
        // Sprawdzamy, czy metoda getInstance zwraca ten sam obiekt singletona za każdym razem
        ActiveVehicle instance1 = ActiveVehicle.getInstance();
        ActiveVehicle instance2 = ActiveVehicle.getInstance();
        assertSame(instance1, instance2, "ActiveVehicle powinno być singletonem");
    }

    @Test
    void testAddAndGetVehicle() {
        // Testujemy dodanie pojazdu do kolekcji oraz pobranie go po ID
        activeVehicle.addVehicle(vehicle1);
        Vehicle retrieved = activeVehicle.getVehicle(1L);
        assertEquals(vehicle1, retrieved, "Dodany i pobrany pojazd powinny być takie same");
    }

    @Test
    void testGetAllActiveVehicles() {
        // Dodajemy dwa pojazdy i sprawdzamy, czy są poprawnie dostępne w mapie
        activeVehicle.addVehicle(vehicle1);
        activeVehicle.addVehicle(vehicle2);
        Map<Long, Vehicle> allVehicles = activeVehicle.getAllActiveVehicles();
        assertEquals(2, allVehicles.size(), "Powinny być 2 pojazdy w mapie");
        assertTrue(allVehicles.containsKey(1L));
        assertTrue(allVehicles.containsKey(2L));
    }

    @Test
    void testRemoveVehicle() {
        // Testujemy usuwanie pojazdu z mapy oraz pozostawienie innego bez zmian
        activeVehicle.addVehicle(vehicle1);
        activeVehicle.addVehicle(vehicle2);

        activeVehicle.removeVehicle(1L);
        assertNull(activeVehicle.getVehicle(1L), "Pojazd o id 1 powinien zostać usunięty");
        assertNotNull(activeVehicle.getVehicle(2L), "Pojazd o id 2 powinien pozostać");
    }

    @Test
    void testRemoveVehicleWhenNotExists() {
        // Usuwanie pojazdu, którego nie ma w kolekcji, nie powinno powodować błędów
        activeVehicle.addVehicle(vehicle1);
        activeVehicle.removeVehicle(999L); // ID nieistniejące
        assertEquals(1, activeVehicle.getAllActiveVehicles().size(), "Mapa powinna nadal zawierać 1 pojazd");
    }
}
// Koniec, Tydzień 13, Testy jednostkowe 1
