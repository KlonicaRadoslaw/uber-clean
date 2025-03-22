package studies.uber_clean.vehicles.domain;

import java.util.ArrayList;
import java.util.List;

// Tydzień 5, Wzorzec Command 1
/**
 * Invoker – wykonuje i zapisuje historię komend.
 */
public class CommandInvoker {
    private final List<Command> history = new ArrayList<>();

    public void executeCommand(Command command) {
        history.add(command);
        command.execute();
    }

    public void showHistory() {
        System.out.println("Historia operacji:");
        history.forEach(cmd -> System.out.println(cmd.getClass().getSimpleName()));
    }
}
// Koniec, Tydzień 5, Wzorzec Command 1