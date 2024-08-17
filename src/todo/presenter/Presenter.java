package todo.presenter;

import todo.model.service.Service;
import todo.model.task.Task;
import todo.veiw.View;

import java.io.IOException;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addTask(String name, String description, String dateExecution, int importance){
        service.addTask(name,description, dateExecution, importance);
        System.out.println("Задача добавлена!");
    }

    public void getTaskInfoAll(){
        String info = service.getTasksInfoAll();
        view.printAnswer(info);
    }

    public Task getById(int id){
        return service.getById(id);
    }

    public void getByImportance(int importance){
        String info = service.getByImportance(importance).toString();
        view.printAnswer(info);
    }

    public void getByTaskCompleted(boolean completed){
        String info = service.getByTaskCompleted(completed).toString();
        view.printAnswer(info);
    }

    public void sortByName(){
        service.sortByName();
        getTaskInfoAll();
    }

    public void sortByDataExecution(){
        service.sortByDataExecution();
        getTaskInfoAll();
    }

    public void sortByImportance(){
        service.sortByImportance();
        getTaskInfoAll();
    }

    public void saveTasks() throws IOException {service.saveTasks();}
    public void readTasks() throws IOException, ClassNotFoundException {service.readTasks();}

}
