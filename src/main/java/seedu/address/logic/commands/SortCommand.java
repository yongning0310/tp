package seedu.address.logic.commands;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.Prefix;
import seedu.address.model.InternshipModel;
import seedu.address.model.internship.Internship;
import seedu.address.model.internship.InternshipComparators;

import java.util.Comparator;
import java.util.List;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.*;

public class SortCommand extends InternshipCommand {
    public static final String COMMAND_WORD = "sort";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Sorts the list of internships by the specified "
            + "category in either ascending (ASC) or descending (DESC) order. "
            + "You should specify the category by using its prefix and then specify the order (either ASC or DESC).\n"
            + "Available categories are:\n"
            + PREFIX_COMPANY_NAME + " - Company Name\n"
            + PREFIX_ROLE + " - Role\n"
            + PREFIX_APPLICATION_STATUS + " - Application Status\n"
            + PREFIX_DEADLINE + " - Deadline\n"
            + PREFIX_START_DATE + " - Start Date\n"
            + PREFIX_DURATION + " - Duration\n"
            + "Format: " + COMMAND_WORD + " CATEGORY_PREFIX ORDER\n"
            + "Example 1: " + COMMAND_WORD + " " + PREFIX_COMPANY_NAME + "ASC\n"
            + "Example 2: " + COMMAND_WORD + " " + PREFIX_ROLE + "DESC";

    public final Prefix category;
    public enum Order {
        ASC,
        DESC
    }

    public final Order sortedOrder;
    public final String MESSAGE_SUCCESS;

    public static final String MESSAGE_INVALID_COLUMN = "The value entered for the category is invalid";
    public static final String MESSAGE_INVALID_ORDER = "The value entered for the order is invalid";


    public SortCommand(Prefix category, Order order){
        requireNonNull(category);
        requireNonNull(order);
        this.category = category;
        this.sortedOrder = order;
        this.MESSAGE_SUCCESS = "Here are the internships sorted by: " + category + " and ordered by: " + sortedOrder;
    }

    /**
     * Executes the sort command, sorting the internship by category
     *
     * @param model The {@code InternshipModel} in which the internships will be sorted.
     * @return A {@code CommandResult} with a success message.
     * @throws CommandException If invalid arguments are given.
     */
    @Override
    public CommandResult execute(InternshipModel model) throws CommandException {
        requireNonNull(model);

        Comparator<Internship> comparator = createComparator();
        model.sortInternships(comparator);
        return new CommandResult(String.format(MESSAGE_SUCCESS));
    }


    private Comparator<Internship> createComparator() throws CommandException {
        Comparator<Internship> comparator;
        if (category == PREFIX_COMPANY_NAME) {
            comparator = InternshipComparators.BY_COMPANY_NAME;
        } else if (category == PREFIX_ROLE) {
            comparator = InternshipComparators.BY_ROLE;
        } else if (category == PREFIX_APPLICATION_STATUS) {
            comparator = InternshipComparators.BY_APPLICATION_STATUS;
        } else if (category == PREFIX_DEADLINE) {
            comparator = InternshipComparators.BY_DEADLINE;
        } else if (category == PREFIX_START_DATE) {
            comparator = InternshipComparators.BY_START_DATE;
        } else if (category == PREFIX_DURATION) {
            comparator = InternshipComparators.BY_DURATION;
        } else {
            throw new CommandException(MESSAGE_INVALID_COLUMN);
        }

        if (sortedOrder == Order.DESC) {
            comparator = comparator.reversed();
        }
        return comparator;

    }
}

