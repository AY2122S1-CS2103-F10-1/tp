package seedu.mrtechrecruiter.model;

import java.nio.file.Path;

import seedu.mrtechrecruiter.commons.core.GuiSettings;

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();

    Path getAddressBookFilePath();

}
