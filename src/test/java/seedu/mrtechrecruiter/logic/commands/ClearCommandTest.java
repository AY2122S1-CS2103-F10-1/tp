package seedu.mrtechrecruiter.logic.commands;

import static seedu.mrtechrecruiter.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.mrtechrecruiter.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.mrtechrecruiter.model.AddressBook;
import seedu.mrtechrecruiter.model.Model;
import seedu.mrtechrecruiter.model.ModelManager;
import seedu.mrtechrecruiter.model.UserPrefs;

public class ClearCommandTest {

    @Test
    public void execute_emptyAddressBook_success() {
        Model model = new ModelManager();
        Model expectedModel = new ModelManager();

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_nonEmptyAddressBook_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel.setAddressBook(new AddressBook());

        assertCommandSuccess(new ClearCommand(), model, ClearCommand.MESSAGE_SUCCESS, expectedModel);
    }

}
