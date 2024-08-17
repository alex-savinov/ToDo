package todo.model.todo;

import todo.model.todo.comparators.ComparatorByDataExecution;
import todo.model.todo.comparators.ComparatorByImportance;
import todo.model.todo.comparators.ComparatorByName;
import todo.model.task.TaskIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Todo<E extends TodoTaskItem<E>>implements Iterable<E>, Serializable {
    private List<E> taskList;

    public Todo(){
        taskList = new ArrayList<E>();
    }

    public Todo(List<E> taskList){
        this.taskList = taskList;
    }

    public void addTask(E task){
        taskList.add(task);
    }



    public E getById(int id){
        for (E task : taskList) {
            if (task.getId()== id) {
                return task;
            }
        }
        return null;
    }

    public  List<E> getByImportance(int value){
        List<E> result = new ArrayList<>();
        for (E task : taskList) {
            if (task.getImportance() == value) result.add(task);
        }
        return result;
    }



    public  List<E> getByTaskCompleted(boolean completed){
        List<E> result = new ArrayList<>();
        for (E task : taskList) {
            if (task.getCompleted() == completed) {
                result.add(task);
            }
        }
        return result;
    }



    public void sortByName(){
        taskList.sort(new ComparatorByName<>());
    }

    public void sortByDataExecution(){
        taskList.sort(new ComparatorByDataExecution<>());
    }

    public void sortByImportance(){
        taskList.sort(new ComparatorByImportance<>());
    }


    @Override
    public Iterator<E> iterator() {
        return new TaskIterator<>(taskList);
    }

    public int getSize() {
        return taskList.size();
    }
}
