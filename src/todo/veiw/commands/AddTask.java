package todo.veiw.commands;

import todo.veiw.ConsoleUI;

public class AddTask extends Command{
    public AddTask(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Поставить задачу";
    }

    public void execute(){
        consoleUI.addTask();
    }
}
