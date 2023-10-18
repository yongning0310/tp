package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPLICATION_STATUS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DURATION;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REQUIREMENT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ROLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_START_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.InternshipBook;
import seedu.address.model.InternshipModel;
import seedu.address.model.Model;
import seedu.address.model.internship.Internship;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.testutil.EditInternshipDescriptorBuilder;
import seedu.address.testutil.EditPersonDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {
    public static final String VALID_COMPANY_NAME_JANESTREET = "Jane Street";
    public static final String VALID_ROLE_JANESTREET = "SWE";
    public static final String VALID_APPLICATIONSTATUS_JANESTREET = "Yet to apply";
    public static final String VALID_DEADLINE_JANESTREET = "01/05/2025";
    public static final String VALID_DURATION_JANESTREET = "2";
    public static final String VALID_STARTDATE_JANESTREET = "05/05/2025";
    public static final String VALID_COMPANY_NAME_OPTIVER = "Optiver";
    public static final String VALID_ROLE_OPTIVER = "UI Designer";
    public static final String VALID_APPLICATIONSTATUS_OPTIVER = "In progress";
    public static final String VALID_DEADLINE_OPTIVER = "03/01/2025";
    public static final String VALID_DURATION_OPTIVER = "5";
    public static final String VALID_STARTDATE_OPTIVER = "06/06/2026";
    public static final String VALID_REQUIREMENT_OPTIVER = "Figma";
    public static final String VALID_REQUIREMENT_JANESTREET = "C++";


    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;


    public static final String COMPANY_NAME_DESC_JANESTREET = " " + PREFIX_COMPANY_NAME + VALID_COMPANY_NAME_JANESTREET;
    public static final String COMPANY_NAME_DESC_OPTIVER = " " + PREFIX_COMPANY_NAME + VALID_COMPANY_NAME_OPTIVER;
    public static final String ROLE_DESC_JANESTREET = " " + PREFIX_ROLE + VALID_ROLE_JANESTREET;
    public static final String ROLE_DESC_OPTIVER = " " + PREFIX_ROLE + VALID_ROLE_OPTIVER;
        public static final String APPLICATION_STATUS_DESC_JANESTREET =
                " " + PREFIX_APPLICATION_STATUS + VALID_APPLICATIONSTATUS_JANESTREET;
        public static final String APPLICATION_STATUS_DESC_OPTIVER =
                " " + PREFIX_APPLICATION_STATUS + VALID_APPLICATIONSTATUS_OPTIVER;
    public static final String DEADLINE_DESC_JANESTREET = " " + PREFIX_DEADLINE + VALID_DEADLINE_JANESTREET;
    public static final String DEADLINE_DESC_OPTIVER = " " + PREFIX_DEADLINE + VALID_DEADLINE_OPTIVER;
    public static final String START_DATE_DESC_JANESTREET = " " + PREFIX_START_DATE + VALID_STARTDATE_JANESTREET;
    public static final String START_DATE_DESC_OPTIVER = " " + PREFIX_START_DATE + VALID_STARTDATE_OPTIVER;
    public static final String DURATION_DESC_JANESTREET = " " + PREFIX_DURATION + VALID_DURATION_JANESTREET;
    public static final String DURATION_DESC_OPTIVER = " " + PREFIX_DURATION + VALID_DURATION_OPTIVER;
    public static final String REQUIREMENT_DESC_JANESTREET = " " + PREFIX_REQUIREMENT + VALID_REQUIREMENT_JANESTREET;
    public static final String REQUIREMENT_DESC_OPTIVER = " " + PREFIX_REQUIREMENT + VALID_REQUIREMENT_OPTIVER;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    public static final String INVALID_COMPANY_NAME_DESC =
            " " + PREFIX_NAME + "Jane&"; // '&' not allowed in company names
    public static final String INVALID_ROLE_DESC = " " + PREFIX_PHONE; // empty string not allowed for roles
    public static final String INVALID_APPLICATION_STATUS_DESC =
            " " + PREFIX_APPLICATION_STATUS + "y@ETO"; // wrong format
    public static final String INVALID_DEADLINE_DESC = " " + PREFIX_DEADLINE; // empty string not allowed for deadlines
    public static final String INVALID_START_DATE_DESC =
            " " + PREFIX_START_DATE; // empty string not allowed for start dates
    public static final String INVALID_DURATION_DESC = " " + PREFIX_DURATION; // empty string not allowed for durations
    public static final String INVALID_REQUIREMENT_DESC =
            " " + PREFIX_REQUIREMENT; // empty string not allowed for requirements

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditPersonDescriptor DESC_AMY;
    public static final EditCommand.EditPersonDescriptor DESC_BOB;

    public static final ModifyCommand.EditInternshipDescriptor DESC_JANESTREET;
    public static final ModifyCommand.EditInternshipDescriptor DESC_OPTIVER;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
        DESC_OPTIVER = new EditInternshipDescriptorBuilder().withCompanyName(VALID_COMPANY_NAME_OPTIVER)
                .withRole(VALID_ROLE_OPTIVER).withApplicationStatus(VALID_APPLICATIONSTATUS_OPTIVER)
                .withDeadline(VALID_DEADLINE_OPTIVER, VALID_STARTDATE_OPTIVER).withStartDate(VALID_STARTDATE_OPTIVER)
                .withDuration(VALID_DURATION_OPTIVER).withRequirements(VALID_REQUIREMENT_OPTIVER).build();
        DESC_JANESTREET = new EditInternshipDescriptorBuilder().withCompanyName(VALID_COMPANY_NAME_JANESTREET)
                .withRole(VALID_ROLE_JANESTREET).withApplicationStatus(VALID_APPLICATIONSTATUS_JANESTREET)
                .withDeadline(VALID_DEADLINE_JANESTREET, VALID_STARTDATE_JANESTREET).withStartDate(VALID_STARTDATE_JANESTREET)
                .withDuration(VALID_DURATION_JANESTREET).withRequirements(VALID_REQUIREMENT_JANESTREET).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertInternshipCommandSuccess(InternshipCommand command, InternshipModel actualModel,
                                                      CommandResult expectedCommandResult,
                                                      InternshipModel expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertInternshipCommandSuccess(InternshipCommand, InternshipModel,
     * CommandResult, InternshipModel)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertInternshipCommandSuccess(InternshipCommand command, InternshipModel actualModel,
                                                      String expectedMessage,
                                                      InternshipModel expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertInternshipCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the internship book, filtered internship list and selected internship in {@code actualModel} remain unchanged
     */
    public static void assertInternshipCommandFailure(InternshipCommand command, InternshipModel actualModel,
                                                      String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        InternshipBook expectedAddressBook = new InternshipBook(actualModel.getInternshipBook());
        List<Internship> expectedFilteredList = new ArrayList<>(actualModel.getFilteredInternshipList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getInternshipBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredInternshipList());
    }

    // Remove when done
    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().fullName.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showInternshipAtIndex(InternshipModel model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredInternshipList().size());

        Internship internship = model.getFilteredInternshipList().get(targetIndex.getZeroBased());
        final String[] splitCompanyName = internship.getCompanyName().companyName.split("\\s+");;

        model.updateFilteredInternshipList(new seedu.address.model.internship.NameContainsKeywordsPredicate(
                Arrays.asList(splitCompanyName[0])));

        assertEquals(1, model.getFilteredInternshipList().size());
    }

}
