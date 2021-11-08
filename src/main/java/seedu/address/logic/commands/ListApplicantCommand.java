package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_APPLICANTS;

import seedu.address.model.Model;

/**
 * Lists all applicants currently found in the applicant book to the user.
 */
public class ListApplicantCommand extends Command {

    public static final String COMMAND_WORD = "list-applicant";

    public static final String MESSAGE_SUCCESS = "Listed all applicants";

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredApplicantList(PREDICATE_SHOW_ALL_APPLICANTS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
