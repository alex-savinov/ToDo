package Todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements TodoTaskItem, Comparable<Task> {
    private long id;
    private String name, description;
    private LocalDateTime dateResolution;
    private String dateExecution;
    private Boolean overdue;
    private int importance;

    public Task(long id, String name, String description, String dateExecution, int importance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateResolution = LocalDateTime.now();
        this.dateExecution = dateExecution;
        this.overdue = false;
        this.importance = importance;
    }

    private String getInfoDateExecution(String dateExecution, LocalDateTime dateResolution ) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Задача поставлена на " + dateExecution + " ( от " + dateResolution.format(formatter) + ").";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDiscription() {
        return description;
    }


    @Override
    public String toString() {
        return "Задача №" + id + ": " + name + ". " + getInfoDateExecution(dateExecution, dateResolution);
    }


    @Override
    public int compareTo(Task object) {
        return name.compareTo(object.name);
    }
}


