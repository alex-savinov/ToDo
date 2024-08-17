package todo.veiw;

import todo.presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        hello();

        try {
            presenter.readTasks();
        } catch (Exception ignore) { }
        while (work){
            printMenu();
            execute();
        }
    }


    public void finish() throws IOException {
        presenter.saveTasks();
        System.out.println("Удачи!");
        work = false;
    }

    public void getById(){
        System.out.println("Введите ID задачи");
        presenter.getById(Integer.parseInt(scanner.nextLine())).getFullInfoTask();
    }

    public void getByImportance(){
        System.out.println("Выберите значимость заданий (от 1 до 5) ");
        presenter.getByImportance(Integer.parseInt(scanner.nextLine()));
    }



    public void getByTaskCompleted(){
        System.out.println("Вам нужны выполненные?(Да/Нет)");
        if (scanner.nextLine().equals("Да")|scanner.nextLine().equals("да")| scanner.nextLine().equals("ДА")){
            presenter.getByTaskCompleted(true);
        }else {
            System.out.println("Вам нужны не выполненные?(Да/Нет)");
            if (scanner.nextLine().equals("Да")|scanner.nextLine().equals("да")| scanner.nextLine().equals("ДА")){
                presenter.getByTaskCompleted(false);
            }else System.out.println("Увы таких нет.");
        }
    }


    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByDataExecution(){
        presenter.sortByDataExecution();
    }
    public void sortByImportance(){
        presenter.sortByImportance();
    }


    public void getTaskInfoAll() {
        presenter.getTaskInfoAll();
    }

    public void addTask() {
        System.out.println("Введите название задачи");
        String name = scanner.nextLine();
        System.out.println("Введите суть задачи");
        String description = scanner.nextLine();
        System.out.println("Введите сроки выполнения задачи в формате: yyyy-MM-dd HH:mm ");
        String dateExecution = scanner.nextLine();
        System.out.println("Введите значимость задачи от 1 до 5");
        String importanceString = scanner.nextLine();
        int importance = Integer.parseInt(importanceString);
        presenter.addTask(name, description,dateExecution,importance);

    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    private void execute() throws IOException, ClassNotFoundException {
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

}
