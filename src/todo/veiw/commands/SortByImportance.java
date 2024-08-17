package todo.veiw.commands;

import todo.veiw.ConsoleUI;

public class SortByImportance extends Command {
    public SortByImportance(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по важности";
    }

    public void execute(){
        consoleUI.sortByImportance();
    }
}
