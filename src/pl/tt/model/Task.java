package pl.tt.model;

import pl.tt.IdProvider;
import pl.tt.persistence.Persistable;

/**
 * @author ciepluchs
 */
public class Task implements Comparable<Task>, Persistable {

    private Long id;
    private String owner;
    private String name;
    private String description;

    public Task(){};

    @Override
    public String toCsv() {
        //TODO method should return object in CSV format (ex. "0,szymon,test name, test desc")
        return "";
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
