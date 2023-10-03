package seedu.address.model;

import static java.util.Objects.requireNonNull;

import java.util.List;

import javafx.collections.ObservableList;
import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.internship.Internship;
import seedu.address.model.internship.UniqueInternshipList;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;

/**
 * Wraps all data at the address-book level
 * Duplicates are not allowed (by .isSamePerson comparison)
 */
public class InternshipBook implements ReadOnlyInternshipBook {


    private final UniqueInternshipList internships;

    {
        internships = new UniqueInternshipList();
    }

    public InternshipBook() {}

    /**
     * Creates an AddressBook using the Persons in the {@code toBeCopied}
     */
    public InternshipBook(ReadOnlyInternshipBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    //// list overwrite operations

    /**
     * Replaces the contents of the person list with {@code persons}.
     * {@code persons} must not contain duplicate persons.
     */
    public void setInternships(List<Internship> internships) {
        this.internships.setInternships(internships);
    }

    /**
     * Resets the existing data of this {@code AddressBook} with {@code newData}.
     */
    public void resetData(ReadOnlyInternshipBook newData) {
        requireNonNull(newData);

        setInternships(newData.getInternshipList());
    }

    //// person-level operations


    /**
     * Returns true if a internship with the same identity as {@code internship} exists in the address book.
     */
    public boolean hasInternship(Internship internship) {
        requireNonNull(internship);
        return this.internships.contains(internship);
    }


    /**
     * Creates an internship in Flagship
     * The internship must not already exist in Flagship.
     */
    public void addInternship(Internship i) {
        this.internships.create(i);
    }

    /**
     * Removes {@code key} from this {@code AddressBook}.
     * {@code key} must exist in the address book.
     */

    public void removeInternship(Internship key) {
        this.internships.remove(key);
    }

    //// util methods

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("internships", internships)
                .toString();
    }

    public void createInternship(Internship i) {
        this.internships.create(i);
    }


    public void setInternship(Internship target, Internship editedInternship) {
        requireNonNull(editedInternship);

        internships.setInternship(target, editedInternship);
    }

    public ObservableList<Internship> getInternshipList() {
        return this.internships.asUnmodifiableObservableList();
    }
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof InternshipBook)) {
            return false;
        }

        InternshipBook otherInternshipBook = (InternshipBook) other;
        return internships.equals(otherInternshipBook.internships);
    }

    @Override
    public int hashCode() {
        return internships.hashCode();
    }

}
