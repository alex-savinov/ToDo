package todo.veiw.commands;

import todo.veiw.ConsoleUI;

public class GetByImportance extends Command {
    public GetByImportance(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Выбрать задачи по значимости";
    }

    public void execute(){
        consoleUI.getByImportance();
    }
}