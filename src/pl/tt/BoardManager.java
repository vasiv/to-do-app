package pl.tt;

import pl.tt.model.Board;
import pl.tt.model.Task;

public class BoardManager {

    public void moveTask(Board source, Board target, Task task) {
        //1. usuń task z tablicy source
        source.removeTask(task);
        //2. dodaj task do tablicy target
        target.addTask(task);
    }
}
