package duke.commands;

import java.io.IOException;

import duke.exception.DukeException;
import duke.task.Task;
import duke.task.ToDo;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.storage.Storage;

/**
 * Represents a Command that only adds ToDo tasks to the TaskList.
 * */
public class AddToDoCommand extends Command {
    private final String description;

    public AddToDoCommand(String description) {
        this.description = description;
    }

    /**
     * Creates and adds a new ToDo task to the TaskList.
     * Prompts Ui to notify the user, then prompts Storage class to append the new task to the task storage file.
     * @param tasks Existing TaskList used by the main Duke class
     * @param ui Existing Ui used by the main Duke class
     * @param storage Existing Storage used by the main Duke class
     * @throws DukeException if something happened to task storage file during runtime
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        Task newTask = new ToDo(description);
        tasks.add(newTask);
        ui.showToUser("You have added: " + newTask, "You have " + tasks.getSize() + " tasks in the list.");
        try {
            storage.appendToFile(newTask);
        } catch (IOException e) {
            throw new DukeException("Unable to write to file. Please run Duke again.");
        }
    }
}
