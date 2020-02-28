package pl.tt;

/**
 * @author ciepluchs
 */
public class Task {

    private Long id;
    private String owner;
    private String name;
    private String description;
    private String type; // TO-DO to można wyrzucić. Niech task nie wie nic o swoim stanie. Zrobić klase Board, która będzie
                         // miała między innymi swoją nazwę i listę tasków. Możemy zrobić, że przy włączeniu programu automatycznie
                         // tworzą się trzy boardy to-do, in-progress, finish. Nowy task automatycznie idzie do to-do.

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
