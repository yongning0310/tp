package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import seedu.address.model.internship.Internship;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class InternshipCard extends UiPart<Region> {

    private static final String FXML = "InternshipListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Internship internship;

    @FXML
    private HBox cardPane;

    @FXML
    private Label id;
    @FXML
    private Label companyName;
    @FXML
    private Label role;
    @FXML
    private Label applicationStatus;
    @FXML
    private Label startDate;
    @FXML
    private Label duration;
    @FXML
    private FlowPane requirements;

    /**
     * Creates a {@code InternshipCode} with the given {@code Internship} and index to display.
     */
    public InternshipCard(Internship internship, int displayedIndex) {
        super(FXML);
        this.internship = internship;
        id.setText(displayedIndex + ". ");
        companyName.setText(internship.getCompanyName().toString());
        role.setText(internship.getRole().toString());
        applicationStatus.setText(internship.getDuration().toString());
        startDate.setText(internship.getStartDate().toString());
        duration.setText(internship.getDuration().toString());
        internship.getRequirements().stream()
                .sorted(Comparator.comparing(req -> req.toString()))
                .forEach(req -> requirements.getChildren().add(new Label(req.toString())));
    }
}
