package todo.veiw.commands;

import todo.veiw.ConsoleUI;

public class GetTaskInfoAll extends Command {
    public GetTaskInfoAll(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Получить список всех задач";
    }

    public void execute(){
        consoleUI.getTaskInfoAll();
    }
}