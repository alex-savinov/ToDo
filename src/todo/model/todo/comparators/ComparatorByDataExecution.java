package todo.model.todo.comparators;

import todo.model.todo.TodoTaskItem;
import java.util.Comparator;

public class ComparatorByDataExecution<T extends TodoTaskItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.getDateExecution().compareTo(o2.getDateExecution());
    }
}