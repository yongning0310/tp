package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.internship.Internship;
import seedu.address.model.person.Person;

// THIS FILE WILL BE REMOVED EVENTUALLY

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the persons list.
     * This list will not contain any duplicate persons.
     */
    ObservableList<Person> getPersonList();

    /**
     * Returns an unmodifiable view of the internship list.
     * This list will not contain any duplicate internship.
     */
    ObservableList<Internship> getInternshipList();

}
