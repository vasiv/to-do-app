package pl.tt.utils;

import pl.tt.model.Task;

import java.util.Comparator;

public class TaskIDComparator implements Comparator<Task> {

    @Override
    public int compare(Task task, Task otherTask) {
        return ((int)task.getID()) - ((int)otherTask.getID());
    }
}
