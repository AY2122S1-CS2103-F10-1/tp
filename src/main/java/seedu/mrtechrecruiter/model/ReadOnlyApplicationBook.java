package seedu.mrtechrecruiter.model;

import javafx.collections.ObservableList;
import seedu.mrtechrecruiter.model.application.Application;

/**
 * An unmodifiable application list.
 */
public interface ReadOnlyApplicationBook {

    /**
     * Returns an unmodifiable application list.
     * This list will not contain any duplicate applications.
     */
    ObservableList<Application> getApplicationList();

}
