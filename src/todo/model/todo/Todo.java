package Todo.model;

import Todo.model.iterators.TaskIterator;
import Todo.model.comparators.ComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Todo<E extends TodoTaskItem>implements Iterable<E>{
    private List<E> taskList;

    public Todo(){
        taskList = new ArrayList<>();
    }
    public void addTask(E task){
        taskList.add(task);
    }

    public void sortByName(){
        taskList.sort(new ComparatorByName<>());
    }






    @Override
    public Iterator<E> iterator() {
        return new TaskIterator<>(taskList);
    }
}
