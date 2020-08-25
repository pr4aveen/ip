package duke.command;

import duke.DukeException;
import duke.Storage;
import duke.UI;
import duke.task.Deadline;
import duke.task.TaskList;

import java.io.IOException;

public class DeadlineCommand extends Command {
    
    private final String argument;

    public DeadlineCommand(String argument) {
        this.argument = argument;
    }

    @Override
    public void execute(Storage storage, TaskList taskList, UI ui) throws DukeException, IOException {
        Deadline newDeadline = Deadline.createNewDeadline(argument);
        storage.writeLineToStorage(newDeadline.generateStorageString());
        ui.printToConsole(taskList.addTaskToList(newDeadline));
    }
}