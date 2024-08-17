package todo.veiw.commands;

import todo.veiw.ConsoleUI;

public class SortByDataExecution extends Command {
    public SortByDataExecution(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по дате";
    }

    public void execute(){
        consoleUI.sortByDataExecution();
    }
}