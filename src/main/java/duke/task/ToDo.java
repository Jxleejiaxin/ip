package duke.task;

/**
 * Represents ToDo task with a description.
 */
public class ToDo extends Task {

    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toTxt() {
        return "T | " + super.toTxt();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}

