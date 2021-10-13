package seedu.mrtechrecruiter.logic.parser;

import static seedu.mrtechrecruiter.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.mrtechrecruiter.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.mrtechrecruiter.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.mrtechrecruiter.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.mrtechrecruiter.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.mrtechrecruiter.logic.parser.CliSyntax.PREFIX_POSITION;

import java.util.stream.Stream;

import seedu.mrtechrecruiter.logic.commands.AddApplicantCommand;
import seedu.mrtechrecruiter.logic.parser.exceptions.ParseException;
import seedu.mrtechrecruiter.model.applicant.Address;
import seedu.mrtechrecruiter.model.applicant.Applicant;
import seedu.mrtechrecruiter.model.applicant.Email;
import seedu.mrtechrecruiter.model.applicant.Name;
import seedu.mrtechrecruiter.model.applicant.Phone;
import seedu.mrtechrecruiter.model.position.Position;

/**
 * Parses input arguments and creates a new AddApplicantCommand object
 */
public class AddApplicantCommandParser implements Parser<AddApplicantCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the AddApplicantCommand
     * and returns an AddApplicantCommand object for execution.
     * @throws ParseException if the user input does not conform to the expected format
     */
    public AddApplicantCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap =
                ArgumentTokenizer.tokenize(args, PREFIX_NAME, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_ADDRESS,
                        PREFIX_POSITION);

        if (!arePrefixesPresent(argMultimap, PREFIX_NAME, PREFIX_ADDRESS, PREFIX_PHONE, PREFIX_EMAIL, PREFIX_POSITION)
                || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddApplicantCommand.MESSAGE_USAGE));
        }

        Name name = ApplicantParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
        Phone phone = ApplicantParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        Email email = ApplicantParserUtil.parseEmail(argMultimap.getValue(PREFIX_EMAIL).get());
        Address address = ApplicantParserUtil.parseAddress(argMultimap.getValue(PREFIX_ADDRESS).get());
        Position dummyPosition = ApplicantParserUtil.parsePosition(argMultimap.getValue(PREFIX_POSITION).get());

        Applicant applicant = new Applicant(name, phone, email, address);

        return new AddApplicantCommand(applicant, dummyPosition);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
