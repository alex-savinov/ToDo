package todo.model.task;

import todo.model.todo.TodoTaskItem;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task implements TodoTaskItem<Task>, Serializable {

    private int id;
    private String name, description;
    private LocalDateTime dateResolution;
    private String dateExecution;
    private boolean completed;
    private int importance;

    public Task(){

    }

    public Task(int id, String name, String description, String dateExecution, int importance) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateResolution = LocalDateTime.now();
        this.dateExecution = dateExecution;
        this.completed = false;
        this.importance = importance;
    }


    private String getInfoDateExecution(String dateExecution, LocalDateTime dateResolution ) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return "Задача поставлена на " + dateExecution + " ( от " + dateResolution.format(formatter) + ")." + ((!completed)?"\n---Задача еще не выполнена---\n" : "\n---Задача выполнена---\n");
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String getDiscription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateResolution() {
        return dateResolution;
    }

    public void setDateResolution(LocalDateTime dateResolution) {
        this.dateResolution = dateResolution;
    }

    public String getDateExecution() {
        return dateExecution;
    }

    public void setDateExecution(String dateExecution) {
        this.dateExecution = dateExecution;
    }

    public boolean getCompleted() {
        return completed;
    }

    @Override
    public void setComplered() {

    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public int getImportance() {
        return importance;
    }

    @Override
    public void setImportance() {

    }

    public void setImportance(int importance) {
        this.importance = importance;
    }

    public void getFullInfoTask(){
        System.out.println(this.toString() + "ОПИСАНИЕ\n" + description + "\n\n" );
    }


    @Override
    public String toString() {
        return "Задача №" + id + ": " + name + ". Приоритет: "+ importance + ". "+ getInfoDateExecution(dateExecution, dateResolution);
    }


    @Override
    public int compareTo(Task object) {
        return name.compareTo(object.name);
    }
}


