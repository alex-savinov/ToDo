package Todo;

public class Service {
    private long idTask;
    private Todo<Task> tasks;

    public Service() {
        tasks = new Todo();
    }

    public void addTask(String name, String description, String dateExecution, int importance){
        Task task = new Task(idTask++, name,description, dateExecution, importance);
        tasks.addTask(task);
    }

    public String getTasksInfoAll() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список задач:\n");

        for (Task task: tasks){
            stringBuilder.append(task);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        tasks.sortByName();
    }

}
