package studies.uber_clean.loyaltyProgram.domain;

import org.junit.jupiter.api.Test;
import studies.uber_clean.rides.domain.LoyaltyService;
import studies.uber_clean.rides.domain.RewardCalculator;

import static org.junit.jupiter.api.Assertions.*;
// Tydzień 13, Unit tests 2
class LoyaltyServiceTest {

    static class FixedRewardCalculator implements RewardCalculator {
        @Override
        public int calculateRewardPoints(double rideCost) {
            return 42; // Stała wartość testowa
        }
    }

    static class LinearRewardCalculator implements RewardCalculator {
        @Override
        public int calculateRewardPoints(double rideCost) {
            return (int) (rideCost * 2); // 2 punkty za każdą jednostkę kosztu
        }
    }

    @Test
    void shouldReturnFixedPointsFromCalculator() {
        LoyaltyService service = new LoyaltyService(new FixedRewardCalculator());
        int result = service.rewardPointsForRide(100.0);
        assertEquals(42, result);
    }

    @Test
    void shouldCalculatePointsBasedOnRideCost() {
        LoyaltyService service = new LoyaltyService(new LinearRewardCalculator());
        int result = service.rewardPointsForRide(10.0);
        assertEquals(20, result);
    }

    @Test
    void shouldReturnZeroPointsWhenCostIsZero() {
        LoyaltyService service = new LoyaltyService(new LinearRewardCalculator());
        int result = service.rewardPointsForRide(0.0);
        assertEquals(0, result);
    }

    @Test
    void shouldHandleNegativeRideCost() {
        LoyaltyService service = new LoyaltyService(new LinearRewardCalculator());
        int result = service.rewardPointsForRide(-5.0);
        assertEquals(-10, result); // W zależności od biznesowych założeń
    }

    @Test
    void shouldWorkWithDifferentImplementations() {
        RewardCalculator calculator = cost -> (int) (Math.sqrt(cost) * 3); // Funkcyjna implementacja
        LoyaltyService service = new LoyaltyService(calculator);
        int result = service.rewardPointsForRide(16.0); // sqrt(16)=4 * 3 = 12
        assertEquals(12, result);
    }
}
// Koniec, Tydzień 13, Unit tests 2