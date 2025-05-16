package studies.uber_clean.loyaltyProgram.domain;

// Tydzień 10, Functional interface 2

public class LoyaltyProgramService {
    private final static int RIDE_VALUE_MULTIPLIER = 10;
    private final static int BONUS_CHECKER_VALUE = 500;
    private final static double BASIC_RIDE_VALUE = 52.5;

    public static void main(String[] args) {
        LoyaltyPointsCalculator calculator = rideValue -> (int) (rideValue * RIDE_VALUE_MULTIPLIER); // 10 punktów za 1$
        BonusEligibilityChecker eligibilityChecker = totalPoints -> totalPoints >= BONUS_CHECKER_VALUE;
        WelcomeMessageProvider messageProvider = name -> "Witaj w programie lojalnościowym, " + name + "!";

        int earnedPoints = calculator.calculatePoints(BASIC_RIDE_VALUE);
        boolean eligible = eligibilityChecker.isEligible(earnedPoints);
        String message = messageProvider.provideMessage("Alicja");

        System.out.println(message);
        System.out.println("Zebrano punktów: " + earnedPoints);
        System.out.println("Czy przysługuje bonus? " + (eligible ? "Tak" : "Nie"));
    }
}
// Koniec, Tydzień 10, Functional interface 2