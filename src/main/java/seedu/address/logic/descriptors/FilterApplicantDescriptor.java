package seedu.address.logic.descriptors;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.commons.util.CollectionUtil;
import seedu.address.model.application.Application.ApplicationStatus;
import seedu.address.model.position.Title;

/**
 * Stores the details to filter the applicant list with. Each non-empty field value will
 * apply an additional filtering criterion to the applicant list.
 */
public class FilterApplicantDescriptor {
    private Title positionTitle;
    private ApplicationStatus applicationStatus;

    public FilterApplicantDescriptor() {}

    /**
     * Copy constructor.
     */
    public FilterApplicantDescriptor(FilterApplicantDescriptor toCopy) {
        setPositionTitle(toCopy.positionTitle);
        setApplicationStatus(toCopy.applicationStatus);
    }

    /**
     * Returns true if at least one field is edited.
     */
    public boolean isAnyFieldEdited() {
        return CollectionUtil.isAnyNonNull(positionTitle, applicationStatus);
    }

    public void setPositionTitle(Title positionTitle) {
        this.positionTitle = positionTitle;
    }

    public Optional<Title> getPositionTitle() {
        return Optional.ofNullable(positionTitle);
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public Optional<ApplicationStatus> getApplicationStatus() {
        return Optional.ofNullable(applicationStatus);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof FilterApplicantDescriptor)) {
            return false;
        }

        // state check
        FilterApplicantDescriptor e = (FilterApplicantDescriptor) other;

        return positionTitle.equals(e.positionTitle)
                && applicationStatus.equals(e.applicationStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positionTitle, applicationStatus);
    }

    @Override
    public String toString() {
        Stream<String> filterDescriptions = Stream.of(getPositionTitle(), getApplicationStatus())
                .flatMap(Optional::stream)
                .map(filter -> filter.getClass().getSimpleName() + ": " + filter);
        return filterDescriptions.collect(Collectors.joining("; ", "", "."));
    }
}
