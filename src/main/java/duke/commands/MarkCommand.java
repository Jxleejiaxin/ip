package duke.commands;

import java.io.IOException;

import duke.exception.DukeException;
import duke.task.TaskList;
import duke.ui.Ui;
import duke.storage.Storage;

/**
 * Represents a Command that marks tasks in the TaskList as done.
 * */
public class MarkCommand extends Command {
    private final int index;

    public MarkCommand(int index) {
        this.index = index;
    }

    /**
     * Finds the task in TaskList by user inputted index. Calls TaskList method to mark the task as done.
     * Marking an already done task as done is allowed and will not result in any error.
     * @param tasks Existing TaskList used by the main Duke class.
     * @param ui Existing Ui used by the main Duke class.
     * @param storage Existing Storage used by the main Duke class.
     * @throws DukeException if something happened to task storage file during runtime or task specified does not exist.
     */
    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        try {
            tasks.mark(this.index);
            int taskNum = index + 1;
            storage.writeToFile(tasks);
            ui.showToUser("You have marked task " + taskNum + " as done.");
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException("Task does not exist at specified index.");
        } catch (IOException e) {
            throw new DukeException("Unable to write to file. Please run Duke again.");
        }
    }
}
