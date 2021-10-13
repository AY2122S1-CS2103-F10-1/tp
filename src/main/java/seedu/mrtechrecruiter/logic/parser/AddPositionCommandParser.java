package seedu.mrtechrecruiter.logic.parser;

import static seedu.mrtechrecruiter.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.mrtechrecruiter.logic.parser.CliSyntax.PREFIX_DESCRIPTION;
import static seedu.mrtechrecruiter.logic.parser.CliSyntax.PREFIX_TITLE;

import java.util.stream.Stream;

import seedu.mrtechrecruiter.logic.commands.AddPositionCommand;
import seedu.mrtechrecruiter.logic.parser.exceptions.ParseException;
import seedu.mrtechrecruiter.model.position.Description;
import seedu.mrtechrecruiter.model.position.Position;
import seedu.mrtechrecruiter.model.position.Title;


/**
 * Parses input arguments and creates a new AddPositionCommand object
 */
public class AddPositionCommandParser implements Parser<AddPositionCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddPositionCommand
     * and returns an AddPositionCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddPositionCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_TITLE, PREFIX_DESCRIPTION);

        if (!arePrefixesPresent(argMultimap, PREFIX_TITLE, PREFIX_DESCRIPTION)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddPositionCommand.MESSAGE_USAGE));
        }

        Title title = ParserUtil.parseTitle(argMultimap.getValue(PREFIX_TITLE).get());
        Description description = ParserUtil.parseDescription(argMultimap.getValue(PREFIX_DESCRIPTION).get());

        Position position = new Position(title, description);

        return new AddPositionCommand(position);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
