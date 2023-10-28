package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.logic.commands.SortCommand;

/**
 * A ui to show active predicates and comparators that is displayed at the header of the application.
 */
public class PredicateComparatorDisplay extends UiPart<Region> {

    private static final String FXML = "PredicateComparatorDisplay.fxml";

    @FXML
    private HBox placeHolderBox;

    @FXML
    private TextArea comparatorDisplay;

    @FXML
    private TextArea filterDisplay;

    public PredicateComparatorDisplay() {
        super(FXML);
        // Initialise the displays for sort and filter information.
        comparatorDisplay.setText("Sorting by c/ in ASC order");
        filterDisplay.setText("FILTER: There is no active filter.");
    }

    public void setComparator(String prefix, SortCommand.Order order) {
        comparatorDisplay.setText(String.format("Sorting by %s in %s order", prefix, order));
    }

    public void setFilter(boolean hasFilter) {
        filterDisplay.setText("FILTER: " + (hasFilter ? "The list is filtered!" : "There is no active filter."));
    }
}
