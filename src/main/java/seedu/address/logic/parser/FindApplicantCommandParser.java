package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindApplicantCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.applicant.NameContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new FindApplicantCommand object
 */
public class FindApplicantCommandParser implements Parser<FindApplicantCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FindApplicantCommand
     * and returns a FindApplicantCommand object for execution.
     *
     * @throws ParseException If the user input does not conform the expected format.
     */
    public FindApplicantCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindApplicantCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new FindApplicantCommand(new NameContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }
}
