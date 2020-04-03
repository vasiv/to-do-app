package pl.tt.model;

import pl.tt.IdProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Optional<Task> getTaskByName(String taskName) {
        for (int i = 0; i < tasks.size(); i++) {
            Task currentTask = tasks.get(i);
            if (currentTask.getName().equals(taskName) == true) {
                return Optional.of(currentTask);
            }
        }

        return Optional.empty();
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
