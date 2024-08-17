package todo.veiw.commands;

import todo.veiw.ConsoleUI;

public class SortByName extends Command {
    public SortByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Отсортировать список по названию";
    }

    public void execute(){
        consoleUI.sortByName();
    }
}
