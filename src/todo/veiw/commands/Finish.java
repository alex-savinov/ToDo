package todo.veiw.commands;

import todo.veiw.ConsoleUI;

import java.io.IOException;

public class Finish extends Command {
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){
        try {consoleUI.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
