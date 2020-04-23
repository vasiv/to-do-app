package pl.tt.model;

import pl.tt.IdProvider;
import pl.tt.utils.TaskNameComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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

    public Optional<Task> getTask(String taskName) {
        for (Task currentTask : tasks) {
            if (taskName.equals(currentTask.getName())) {
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
