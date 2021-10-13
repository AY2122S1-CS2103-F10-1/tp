package seedu.mrtechrecruiter.logic.commands;

import static seedu.mrtechrecruiter.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.mrtechrecruiter.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.mrtechrecruiter.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.mrtechrecruiter.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.mrtechrecruiter.model.Model;
import seedu.mrtechrecruiter.model.ModelManager;
import seedu.mrtechrecruiter.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for ListCommand.
 */
public class ListCommandTest {

    private Model model;
    private Model expectedModel;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
        expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_listIsNotFiltered_showsSameList() {
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_listIsFiltered_showsEverything() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        assertCommandSuccess(new ListCommand(), model, ListCommand.MESSAGE_SUCCESS, expectedModel);
    }
}
