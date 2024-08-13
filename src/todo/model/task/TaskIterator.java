package Todo.model.todo.iterators;

import java.util.Iterator;
import java.util.List;

public class TaskIterator<E> implements Iterator<E> {
    private int index;
    private List<E> taskList;

    public TaskIterator(List<E> taskList) {
        this.taskList = taskList;
    }

    @Override
    public boolean hasNext() {
        return index < taskList.size();
    }

    @Override
    public E next() {
        return taskList.get(index++);
    }
}
