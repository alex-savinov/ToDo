package todo.veiw.commands;

import todo.veiw.ConsoleUI;

import java.io.IOException;

public abstract class Command {
    String description;
    ConsoleUI consoleUI;

    public Command(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    public String getDescription() {
        return description;
    }

    public abstract void execute() throws IOException, ClassNotFoundException;
}