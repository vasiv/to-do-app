package pl.tt.utils;

import pl.tt.model.Task;

import java.util.Comparator;

public class TaskNameComparator implements Comparator<Task> {

    @Override
    public int compare(Task task, Task otherTask) {
        return task.getName().compareTo(otherTask.getName());
    }
}
