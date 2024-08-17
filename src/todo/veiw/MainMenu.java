package todo.veiw;

import todo.veiw.commands.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddTask(consoleUI));
        commandList.add(new GetById(consoleUI));
        commandList.add(new GetByImportance(consoleUI));
        commandList.add(new GetByTaskCompleted(consoleUI));
        commandList.add(new GetTaskInfoAll(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByDataExecution(consoleUI));
        commandList.add(new SortByImportance(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu(){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) throws IOException, ClassNotFoundException {
        Command command = commandList.get(choice-1);
        command.execute();
    }

    public int getSize(){
        return commandList.size();
    }

}
