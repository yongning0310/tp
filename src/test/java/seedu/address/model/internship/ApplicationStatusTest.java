package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class ApplicationStatusTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new ApplicationStatus(null));
    }

    @Test
    public void constructor_invalidApplicationStatus_throwsIllegalArgumentException() {
        String invalidApplicationStatus = "";
        assertThrows(IllegalArgumentException.class, () -> new ApplicationStatus(invalidApplicationStatus));
    }

    @Test
    public void isValidApplicationStatus() {
        // null applicationStatus
        assertFalse(ApplicationStatus.isValidApplicationStatus(null));

        // invalid applicationStatuses
        assertFalse(ApplicationStatus.isValidApplicationStatus("")); // empty string
        assertFalse(ApplicationStatus.isValidApplicationStatus(" ")); // spaces only
        assertFalse(ApplicationStatus.isValidApplicationStatus("Still trying")); // invalid status

        // valid applicationStatuses
        assertTrue(ApplicationStatus.isValidApplicationStatus("Yet to apply"));
        assertTrue(ApplicationStatus.isValidApplicationStatus("Applied"));
        assertTrue(ApplicationStatus.isValidApplicationStatus("In progress"));
        assertTrue(ApplicationStatus.isValidApplicationStatus("Accepted"));
        assertTrue(ApplicationStatus.isValidApplicationStatus("Rejected"));
    }

    @Test
    public void equals() {
        ApplicationStatus applicationStatus = new ApplicationStatus("Yet to apply");

        // same values -> returns true
        assertTrue(applicationStatus.equals(new ApplicationStatus("Yet to apply")));

        // same object -> returns true
        assertTrue(applicationStatus.equals(applicationStatus));

        // null -> returns false
        assertFalse(applicationStatus.equals(null));

        // different values -> returns false
        assertFalse(applicationStatus.equals(new ApplicationStatus("Applied")));
        assertFalse(applicationStatus.equals(new ApplicationStatus("Accepted")));
        assertFalse(applicationStatus.equals(new ApplicationStatus("Rejected")));
    }
}
