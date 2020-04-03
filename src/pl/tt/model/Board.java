package pl.tt.model;

import pl.tt.IdProvider;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private Long id;
    private String type;
    private List<Task> tasks;

    public Board(String type) {
        this.type = type;
        this.id = IdProvider.generateId();
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(tasks.get(i));
        }
    }

    public String getType() {
        return type;
    }

}
