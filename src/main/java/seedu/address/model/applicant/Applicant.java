package seedu.address.model.applicant;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.application.Application;
import seedu.address.model.application.Application.ApplicationStatus;
import seedu.address.model.position.Position;
import seedu.address.model.position.Title;

/**
 * Represents an Applicant in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Applicant {

    // Identity fields
    private final Name name;
    private final Phone phone;
    private final Email email;

    // Data fields
    private final Address address;
    private Application application;

    /**
     * Every field must be present and not null
     */
    public Applicant(Name name, Phone phone, Email email, Address address, Position dummyPosition) {
        requireAllNonNull(name, phone, email, address);
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.application = new Application(this, dummyPosition);
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

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }

    /**
     * Returns true if this applicant is applying to the given position.
     */
    public boolean isApplyingTo(Position position) {
        requireNonNull(position);
        return application.getPosition().equals(position);
    }

    /**
     * Returns true if this applicant is applying to a position with the given title.
     */
    public boolean isApplyingToPositionWithTitle(Title positionTitle) {
        requireNonNull(positionTitle);
        return application.getPosition().getTitle().equals(positionTitle);
    }

    /**
     * Returns true if this applicant has the given application status.
     */
    public boolean hasApplicationStatus(ApplicationStatus applicationStatus) {
        requireNonNull(applicationStatus);
        return application.getStatus().equals(applicationStatus);
    }

    /**
     * Returns true if both applicants have the same name.
     * This defines a weaker notion of equality between two applicants.
     */
    public boolean isSameApplicant(Applicant otherApplicant) {
        if (otherApplicant == this) {
            return true;
        }

        return otherApplicant != null
                && name.equals(otherApplicant.name);
    }

    /**
     * Returns true if both applicants have the same identity and data fields.
     * This defines a stronger notion of equality between two applicants.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Applicant)) {
            return false;
        }

        Applicant otherApplicant = (Applicant) other;
        return name.equals(otherApplicant.name)
                && phone.equals(otherApplicant.phone)
                && email.equals(otherApplicant.email)
                && address.equals(otherApplicant.address);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, phone, email, address);
    }

    @Override
    public String toString() {
        return name
                + "; Phone: "
                + phone
                + "; Email: "
                + email
                + "; Address: "
                + address
                + "; Application: "
                + application;
    }

    public String getApplicationSummary() {
        return "Applied for: " + application.getPosition().getTitle() + "; Status: " + application.getStatus();
    }

}
