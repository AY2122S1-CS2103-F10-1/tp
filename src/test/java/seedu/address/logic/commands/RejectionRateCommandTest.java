package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.*;
import seedu.address.model.applicant.*;
import seedu.address.model.applicant.applicantparticulars.ApplicantParticulars;
import seedu.address.model.application.Application.ApplicationStatus;
import seedu.address.model.position.Description;
import seedu.address.model.position.Position;
import seedu.address.model.position.Title;
import seedu.address.testutil.PositionBuilder;

public class RejectionRateCommandTest {
    private Model model;

    @BeforeEach
    public void setUp() {
        model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    }

    @Test
    public void constructor_nullPosition_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new RejectionRateCommand(null));
    }

    @Test
    public void execute_nonExistingPosition_throwsCommandException() {
        Position validPosition = new PositionBuilder().build();
        Position invalidPosition = new Position(new Title("Senior Software Engineer"),
                new Description("Supervises and ensures code is integrated correctly."));
        model.addPosition(validPosition);
        assertThrows(CommandException.class, () -> new RejectionRateCommand(invalidPosition.getTitle()));
    }

    @Test
    public void execute_existingPositionWithExistingApplicant_calculationSuccessful() throws Exception {
        Position validPosition = new PositionBuilder().build();
        model.addPosition(validPosition);
        Applicant applicant = new Applicant(new Name("Amy"), new Phone("12345678")
                , new Email("test@gmail.com")
                , new Address("Blk 123, Jurong West Ave 6, #08-111")
                , validPosition);
        applicant = applicant.markAs(ApplicationStatus.REJECTED);
        model.addApplicantWithParticulars(new ApplicantParticulars(new Name("Amy"), new Phone("12345678")
                , new Email("test@gmail.com")
                , new Address("Blk 123, Jurong West Ave 6, #08-111")
                , validPosition.getTitle()));
        CommandResult commandResult = new RejectionRateCommand(validPosition.getTitle()).execute(model);
        float rejectionRate = model.calculateRejectionRate(validPosition);
        assertEquals(String.format(RejectionRateCommand.MESSAGE_SUCCESS, validPosition, rejectionRate),
                commandResult.getFeedbackToUser());
    }

    @Test
    public void execute_changeRejectionRateAfterAddingApplicant_() throws Exception {
        Position validPosition = new PositionBuilder().build();
        model.addPosition(validPosition);
        ApplicantParticulars applicantParticulars = new ApplicantParticulars(new Name("Amy"), new Phone("12345678")
                , new Email("test@gmail.com")
                , new Address("Blk 123, Jurong West Ave 6, #08-111"), validPosition.getTitle());
        model.addApplicantWithParticulars(applicantParticulars);
        CommandResult commandResult = new RejectionRateCommand(validPosition.getTitle()).execute(model);
        float initialRejectionRate = model.calculateRejectionRate(validPosition);

    }

}
