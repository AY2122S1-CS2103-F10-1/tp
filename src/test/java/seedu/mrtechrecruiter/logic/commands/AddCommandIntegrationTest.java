package seedu.mrtechrecruiter.logic.commands;

import static seedu.mrtechrecruiter.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.mrtechrecruiter.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.mrtechrecruiter.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.mrtechrecruiter.model.Model;
import seedu.mrtechrecruiter.model.ModelManager;
import seedu.mrtechrecruiter.model.UserPrefs;
import seedu.mrtechrecruiter.model.person.Person;
import seedu.mrtechrecruiter.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) for {@code AddCommand}.
 */
public class AddCommandIntegrationTest {

    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void execute_newPerson_success() {
        Person validPerson = new PersonBuilder().build();

        Model expectedModel = new ModelManager(model.getAddressBook(), new UserPrefs());
        expectedModel.addPerson(validPerson);

        assertCommandSuccess(new AddCommand(validPerson), model,
                String.format(AddCommand.MESSAGE_SUCCESS, validPerson), expectedModel);
    }

    @Test
    public void execute_duplicatePerson_throwsCommandException() {
        Person personInList = model.getAddressBook().getPersonList().get(0);
        assertCommandFailure(new AddCommand(personInList), model, AddCommand.MESSAGE_DUPLICATE_PERSON);
    }

}
