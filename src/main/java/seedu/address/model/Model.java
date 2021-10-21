package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.applicant.Applicant;
import seedu.address.model.applicant.Name;
import seedu.address.model.applicant.applicantparticulars.ApplicantParticulars;
import seedu.address.model.person.Person;
import seedu.address.model.position.Position;
import seedu.address.model.position.Title;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;
    Predicate<Position> PREDICATE_SHOW_ALL_POSITIONS = unused -> true;
    Predicate<Applicant> PREDICATE_SHOW_ALL_APPLICANTS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Returns the user prefs' position book file path.
     */
    Path getPositionBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Deletes the given applicant.
     * The applicant must exist in the address book.
     */
    void deleteApplicant(Applicant target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Adds a new applicant to MrTechRecruiter with the given particulars.
     * The intended applicant must not already exist in the applicant book.
     * @return the newly added applicant.
     */
    Applicant addApplicantWithParticulars(ApplicantParticulars applicantParticulars);

    /**
     * Returns true if an applicant named {@code applicantName} exists in MrTechRecruiter.
     */
    boolean hasApplicantWithName(Name applicantName);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /**
     * Replaces the given applicant {@code target} with {@code editedApplicant}.
     * {@code target} must exist in MrTechRecruiter.
     * The applicant identity of {@code editedApplicant} must not be the same as another existing applicant in
     * MrTechRecruiter.
     */
    void setApplicant(Applicant target, Applicant editedApplicant);

    /**
     * Replaces the given position {@code target} with {@code editedPosition}.
     * {@code target} must exist in MrTechRecruiter.
     * The position identity of {@code editedPosition} must not be the same as another existing position in
     * MrTechRecruiter.
     */
    void setPosition(Position position, Position editedPosition);



    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /** Returns an unmodifiable view of the filtered applicant list */
    ObservableList<Applicant> getFilteredApplicantList();

    /** Returns an unmodifiable view of the filtered position list */
    ObservableList<Position> getFilteredPositionList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    /**
     * Updates the filter of the filtered position list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredApplicantList(Predicate<Applicant> predicate);

    //=========== Filtered Position List Accessors =============================================================
    /**
     * Updates the filter of the filtered position list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPositionList(Predicate<Position> predicate);

    /**
     * Replaces position book data with the data in {@code positionBook}.
     */
    void setPositionBook(ReadOnlyPositionBook positionBook);

    /** Returns the AddressBook */
    ReadOnlyPositionBook getPositionBook();

    // Position related methods

    boolean hasPosition(Position position);
    boolean hasPositionWithTitle(Title title);

    void addPosition(Position toAdd);

    void deletePosition(Position positionToDelete);

    // Applicant related methods ==============================================================================
    Path getApplicantBookFilePath();

    void updateApplicantsWithPosition(Position positionToEdit, Position editedPosition);
}
