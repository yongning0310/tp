package seedu.address.ui;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

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
        //comparatorDisplay = (TextArea) placeHolderBox.lookup("#comparatorDisplay");
        //filterDisplay = (TextArea) placeHolderBox.lookup("#filterDisplay");
    }

    public void setComparator(boolean hasComparator) {
        comparatorDisplay.setText("SORT: " + (hasComparator ? "A special sort is active!" : "The list is sorted in its default order."));
    }

    public void setFilter(boolean hasFilter) {
        filterDisplay.setText("FILTER: " + (hasFilter ? "The list is filtered!" : "There is no active filter."));
    }
}
