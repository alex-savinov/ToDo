package todo.model.todo.comparators;

import todo.model.todo.TodoTaskItem;
import java.util.Comparator;

public class ComparatorByImportance<T extends TodoTaskItem> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return Integer.compare(o2.getImportance(), o1.getImportance());
    }
}