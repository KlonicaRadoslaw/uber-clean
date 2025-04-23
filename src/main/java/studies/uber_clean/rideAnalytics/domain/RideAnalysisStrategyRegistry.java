package studies.uber_clean.rideAnalytics.domain;

import java.util.HashMap;
import java.util.Map;

class RideAnalysisStrategyRegistry {
    private final Map<String, AnalysisStrategy> strategies = new HashMap<>();

    public void register(String name, AnalysisStrategy strategy) {
        strategies.put(name.toLowerCase(), strategy);
    }

    public AnalysisStrategy getStrategy(String name) {
        return strategies.get(name);
    }
}
