package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.internship.Internship;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyInternshipBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Internship> getInternshipList();

}
