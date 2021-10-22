package seedu.address.model.applicant.applicantparticulars;

import seedu.address.model.applicant.Address;
import seedu.address.model.applicant.Email;
import seedu.address.model.applicant.Name;
import seedu.address.model.applicant.Phone;
import seedu.address.model.application.Application.ApplicationStatus;
import seedu.address.model.position.Title;

/**
 * A read-only utility class used to hold an applicant's particulars.
 */
public class ApplicantParticulars {
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Address address;
    private final Title positionTitle;
    private ApplicationStatus applicationStatus;

    /**
     * Constructor for an ApplicantParticulars object.
     */
    public ApplicantParticulars(Name name, Phone phone, Email email, Address address, Title positionTitle) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.positionTitle = positionTitle;
    }

    public Name getName() {
        return name;
    }

    public Phone getPhone() {
        return phone;
    }

    public Email getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public Title getPositionTitle() {
        return positionTitle;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
}
