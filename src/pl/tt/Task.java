package pl.tt;

/**
 * @author ciepluchs
 */
public class Task {

    private Long id;
    private String owner;
    private String name;
    private String description;
    private String type;

    public Task(String owner, String name) {
        id = IdProvider.generateId();
        this.owner = owner;
        this.name = name;
        type = "TO-DO";
    }

    public Task(String owner, String name, String description) {
        id = IdProvider.generateId();
        this.owner = owner;
        this.name = name;
        this.description = description;
        type = "TO-DO";
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
