package seedu.mrtechrecruiter.logic.parser;

import seedu.mrtechrecruiter.commons.core.Messages;
import seedu.mrtechrecruiter.commons.core.index.Index;
import seedu.mrtechrecruiter.logic.commands.DeletePositionCommand;
import seedu.mrtechrecruiter.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new DeletePositionCommand object
 */
public class DeletePositionCommandParser implements Parser<DeletePositionCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the DeletePositionCommand
     * and returns a DeletePositionCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public DeletePositionCommand parse(String args) throws ParseException {
        try {
            Index index = ParserUtil.parseIndex(args);
            return new DeletePositionCommand(index);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(Messages.MESSAGE_INVALID_COMMAND_FORMAT, DeletePositionCommand.MESSAGE_USAGE), pe);
        }
    }
}
