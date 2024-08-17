package todo.model.task;

public class TaskBuilder {
    private int idTask=1;

    public TaskBuilder(){
        idTask=1;
    }

    public TaskBuilder(int id){
        idTask=id+1;
    }

    public Task build(String name, String description, String dateExecution, int importance){
        return new Task(idTask++, name, description, dateExecution, importance);
    }


}
