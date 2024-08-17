package todo.model.service;

import todo.model.task.Task;
import todo.model.task.TaskBuilder;
import todo.model.todo.Todo;

import java.io.IOException;
import java.util.List;

public class Service {
    private Todo<Task> tasks;
    private Writable writable;
    private TaskBuilder taskBuilder;

    public Service() {
        this.tasks = new Todo<>();
        this.taskBuilder = new TaskBuilder();
        this.writable = new FileHandler();
    }

    public void addTask(String name, String description, String dateExecution, int importance) {
        Task task = taskBuilder.build(name, description, dateExecution, importance);
        tasks.addTask(task);
    }

    public String getTasksInfoAll() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список задач:\n\n");

        for (Task task : tasks) {
            stringBuilder.append(task);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Todo<Task> getTasks(){
        return tasks;
    }

    public Task getById(int id){
        return tasks.getById(id);
    }

    public List<Task> getByImportance(int importance){
        return tasks.getByImportance(importance);
    }

    public List<Task> getByTaskCompleted(boolean completed){
        return tasks.getByTaskCompleted(completed);
    }


    public void sortByName() {
        tasks.sortByName();
    }
    public void sortByDataExecution() {tasks.sortByDataExecution();}
    public void sortByImportance() {tasks.sortByImportance();}

    public boolean saveTasks() throws IOException {
        writable.save(tasks);
        return true;
    }

    public boolean readTasks() throws IOException, ClassNotFoundException {
        tasks = (Todo<Task>) writable.read();
        if (tasks != null) {
            taskBuilder = new TaskBuilder(tasks.getSize());
            return true;
        }
        return false;
    }


}
