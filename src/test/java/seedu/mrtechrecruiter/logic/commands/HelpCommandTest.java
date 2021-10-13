package seedu.mrtechrecruiter.logic.commands;

import org.junit.jupiter.api.Test;

import seedu.mrtechrecruiter.model.Model;
import seedu.mrtechrecruiter.model.ModelManager;

public class HelpCommandTest {
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(HelpCommand.SHOWING_HELP_MESSAGE, true, false);
        CommandTestUtil.assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }
}
