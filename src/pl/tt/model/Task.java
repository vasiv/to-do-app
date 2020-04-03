package pl.tt.model;

import com.sun.istack.internal.NotNull;
import pl.tt.IdProvider;

/**
 * @author TenDan
 */
public class Task implements Comparable<Task> {

    private Long id;
    private String owner;
    private String name;
    private String description;

    public Task(String owner, String name) {
        id = IdProvider.generateId();
        this.owner = owner;
        this.name = name;
        this.description = "";
    }

    public Task(String owner, String name, String description) {
        id = IdProvider.generateId();
        this.owner = owner;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public long getID() {
        return id;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(Task otherTask) {
        return otherTask.getName().compareTo(this.getName());
    }
}
