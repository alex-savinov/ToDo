package todo.veiw.commands;

import todo.veiw.ConsoleUI;


public class GetById extends Command {
    public GetById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Ознакомится с задачей по ID";
    }

    public void execute(){
      consoleUI.getById();
    }
}