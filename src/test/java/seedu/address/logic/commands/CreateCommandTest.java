package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;
//import static seedu.address.testutil.TypicalInternships.JANE_STREET;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

import org.junit.jupiter.api.Test;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.internship.Internship;
import seedu.address.model.person.Person;
import seedu.address.testutil.InternshipBuilder;

public class CreateCommandTest {
    @Test
    public void constructor_nullInternship_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CreateCommand(null));
    }

    @Test
    public void execute_internshipAcceptedByModel_createSuccessful() throws Exception {
        CreateCommandTest.ModelStufAcceptingInternshipCreated modelStub = new CreateCommandTest
                .ModelStufAcceptingInternshipCreated();
        Internship validInternship = new InternshipBuilder().build();

        CommandResult commandResult = new CreateCommand(validInternship).execute(modelStub);

        assertEquals(String.format(CreateCommand.MESSAGE_SUCCESS, Messages.format(validInternship)),
                commandResult.getFeedbackToUser());
        assertEquals(Arrays.asList(validInternship), modelStub.internshipsCreated);
    }

    @Test
    public void execute_duplicateInternship_throwsCommandException() {
        Internship validInternship = new InternshipBuilder().build();
        CreateCommand createCommand = new CreateCommand(validInternship);
        CreateCommandTest.ModelStub modelStub = new CreateCommandTest.ModelStubWithInternship(validInternship);

        assertThrows(
                CommandException.class,
                CreateCommand.MESSAGE_DUPLICATE_INTERNSHIP, () -> createCommand.execute(modelStub)
        );
    }

    @Test
    public void equals() {
        Internship janeStreet = new InternshipBuilder().withCompanyName("JaneStreet").build();
        Internship google = new InternshipBuilder().withCompanyName("Google").build();
        CreateCommand addJaneStreetCommand = new CreateCommand(janeStreet);
        CreateCommand addGoogleCommand = new CreateCommand(google);

        // same object -> returns true
        assertTrue(addJaneStreetCommand.equals(addJaneStreetCommand));

        // same values -> returns true
        CreateCommand addJaneStreetCommandCopy = new CreateCommand(janeStreet);
        assertTrue(addJaneStreetCommand.equals(addJaneStreetCommandCopy));

        // different types -> returns false
        assertFalse(addJaneStreetCommand.equals(1));

        // null -> returns false
        assertFalse(addJaneStreetCommand.equals(null));

        // different person -> returns false
        assertFalse(addJaneStreetCommand.equals(addGoogleCommand));
    }

    //    @Test
    //    public void toStringMethod() {
    //        AddCommand addCommand = new AddCommand(ALICE);
    //        String expected = AddCommand.class.getCanonicalName() + "{toAdd=" + ALICE + "}";
    //        assertEquals(expected, addCommand.toString());
    //    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void createInternship(Internship internship) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasInternship(Internship internship) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deleteInternship(Internship target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setInternship(Internship target, Internship editedInternship) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Internship> getFilteredInternshipList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredInternshipList(Predicate<Internship> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }
    }
    /**
     * A Model stub that contains a single internship.
     */
    private class ModelStubWithInternship extends ModelStub {
        private final Internship internship;

        ModelStubWithInternship(Internship internship) {
            requireNonNull(internship);
            this.internship = internship;
        }

        @Override
        public boolean hasInternship(Internship internship) {
            requireNonNull(internship);
            return this.internship.isSameInternship(internship);
        }
    }

    /**
     * A Model stub that always accept the internship being added.
     */
    private class ModelStufAcceptingInternshipCreated extends ModelStub {
        final ArrayList<Internship> internshipsCreated = new ArrayList<>();

        @Override
        public boolean hasInternship(Internship internship) {
            requireNonNull(internship);
            return internshipsCreated.stream().anyMatch(internship::isSameInternship);
        }

        @Override
        public void createInternship(Internship internship) {
            requireNonNull(internship);
            internshipsCreated.add(internship);
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            return new AddressBook();
        }
    }
}
