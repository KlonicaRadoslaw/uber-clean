package studies.uber_clean.discounts.domain;

import java.util.Stack;

// Tydzień 5, Wzorzec Command 2
public class DiscountInvoker {
    private final Stack<DiscountCommand> history = new Stack<>();

    public void executeCommand(DiscountCommand command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            DiscountCommand command = history.pop();
            command.undo();
        }
    }

    public void undoAllCommands() {
        while (!history.isEmpty()) {
            history.pop().undo();
        }
    }
}
// Koniec, Tydzień 5, Wzorzec Command 2