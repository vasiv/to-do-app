package pl.tt.model;

import pl.tt.persistence.Persistable;

import java.util.Date;

/**
 * @author ciepluchs
 */
public class TaskWithDueDate extends Task implements Persistable {

    Date dueDate;

    public TaskWithDueDate(String owner, String name, String description, Date date){
        super(owner, name, description);
        this.dueDate = date;
    }

    //TODO This class also should implement toCsv method from Persistable interface.
}
