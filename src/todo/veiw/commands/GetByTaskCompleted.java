package todo.veiw.commands;

import todo.veiw.ConsoleUI;

public class GetByTaskCompleted extends Command {
    public GetByTaskCompleted(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выбрать задачи выполненные / не выполненные";
    }

    public void execute(){
        consoleUI.getByTaskCompleted();
    }
}