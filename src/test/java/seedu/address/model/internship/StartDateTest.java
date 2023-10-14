package seedu.address.model.internship;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.Assert.assertThrows;

class StartDateTest {
    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new StartDate(null));
    }

    @Test
    public void constructor_invalidStartDate_throwsIllegalArgumentException() {
        String invalidStartDate = "";
        assertThrows(IllegalArgumentException.class, () -> new StartDate(invalidStartDate));
    }

    @Test
    public void isValidStartDate() {
        // null startDate number
        assertThrows(NullPointerException.class, () -> StartDate.isValidStartDate(null));

        // invalid startDate
        assertFalse(StartDate.isValidStartDate("")); // empty string
        assertFalse(StartDate.isValidStartDate(" ")); // spaces only
        assertFalse(StartDate.isValidStartDate("91")); // not in valid format
        assertFalse(StartDate.isValidStartDate("10 Oct 2023")); // not in valid format
        assertFalse(StartDate.isValidStartDate("10-10-2023")); // not in valid format
        assertFalse(StartDate.isValidStartDate("startDate")); // not in valid format
        assertFalse(StartDate.isValidStartDate("10/13/2023")); // not in valid format

        // valid startDate numbers
        assertTrue(StartDate.isValidStartDate("10/01/2022")); // exactly 3 numbers
        assertTrue(StartDate.isValidStartDate("31/12/2023"));
    }

    @Test
    public void equals() {
        StartDate startDate = new StartDate("10/10/2024");

        // same values -> returns true
        assertTrue(startDate.equals(new StartDate("10/10/2024")));

        // same object -> returns true
        assertTrue(startDate.equals(startDate));

        // null -> returns false
        assertFalse(startDate.equals(null));

        // different types -> returns false
        assertFalse(startDate.equals(5.0f));

        // different values -> returns false
        assertFalse(startDate.equals(new StartDate("30/12/2025")));
    }

}