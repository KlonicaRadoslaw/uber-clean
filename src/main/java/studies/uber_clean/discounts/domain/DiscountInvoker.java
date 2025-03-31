package studies.uber_clean.discounts.domain;

import java.util.Stack;

// Tydzień 5, Wzorzec Command 2
public class DiscountInvoker {
    private final Stack<DiscountCommand> history = new Stack<>();
    private final Stack<DiscountBundleMemento> mementoHistory = new Stack<>();

    public void saveMemento(DiscountBundleMemento memento) {
        mementoHistory.push(memento);
    }

    public void executeCommand(DiscountCommand command, DiscountBundle discountBundle) {
        // Zapisz stan przed wykonaniem operacji jako Memento
        mementoHistory.push(discountBundle.saveState());

        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            DiscountCommand command = history.pop();
            command.undo();
            mementoHistory.pop();
        }
    }

    public void undoLastState(DiscountBundle discountBundle) {
        if (!mementoHistory.isEmpty()) {
            DiscountBundleMemento memento = mementoHistory.pop();
            discountBundle.restoreState(memento); // Przywrócenie stanu
        }
    }

    public void undoAllCommands() {
        while (!history.isEmpty()) {
            history.pop().undo();
        }
        mementoHistory.clear(); // Czyścimy historię mementów
    }
}
// Koniec, Tydzień 5, Wzorzec Command 2