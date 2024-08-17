package todo.model.todo;

public interface TodoTaskItem<T> extends Comparable<T>{
    String getName();
    String getDiscription();
    int getId();
    String getDateExecution();
    void getFullInfoTask();
    boolean getCompleted();
    void setComplered();
    int getImportance();
    void setImportance();
}
