package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_POSITION;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddApplicantCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.applicant.Address;
import seedu.address.model.applicant.ApplicantParticulars;
import seedu.address.model.applicant.Email;
import seedu.address.model.applicant.Name;
import seedu.address.model.applicant.Phone;
import seedu.address.model.position.Title;

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
        requireNonNull(args);
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
        Title positionTitle = ApplicantParserUtil.parseTitle(argMultimap.getValue(PREFIX_POSITION).get());

        ApplicantParticulars applicantParticulars =
                new ApplicantParticulars(name, phone, email, address, positionTitle);

        return new AddApplicantCommand(applicantParticulars);
    }

    /**
     * Returns true if none of the prefixes contains empty {@code Optional} values in the given
     * {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }

}
