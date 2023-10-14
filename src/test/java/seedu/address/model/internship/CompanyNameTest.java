package seedu.address.model.internship;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static seedu.address.testutil.Assert.assertThrows;

class CompanyNameTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new CompanyName(null));
    }

    @Test
    public void constructor_invalidCompanyName_throwsIllegalArgumentException() {
        String invalidCompanyName = "";
        assertThrows(IllegalArgumentException.class, () -> new CompanyName(invalidCompanyName));
    }

    @Test
    public void isValidCompanyName() {
        // null companyName
        assertThrows(NullPointerException.class, () -> CompanyName.isValidCompanyName(null));

        // invalid companyName
        assertFalse(CompanyName.isValidCompanyName("")); // empty string
        assertFalse(CompanyName.isValidCompanyName(" ")); // spaces only
        assertFalse(CompanyName.isValidCompanyName("^")); // only non-alphanumeric characters
        assertFalse(CompanyName.isValidCompanyName("dbs*")); // contains non-alphanumeric characters

        // valid companyName
        assertTrue(CompanyName.isValidCompanyName("takashimaya")); // alphabets only
        assertTrue(CompanyName.isValidCompanyName("111")); // numbers only
        assertTrue(CompanyName.isValidCompanyName("123 shopping centre")); // alphanumeric characters
        assertTrue(CompanyName.isValidCompanyName("Capital Trading Centre")); // with capital letters
        assertTrue(CompanyName.isValidCompanyName("DBS Bank 2nd branch")); // long companyNames
    }

    @Test
    public void equals() {
        CompanyName companyName = new CompanyName("Valid CompanyName");

        // same values -> returns true
        assertTrue(companyName.equals(new CompanyName("Valid CompanyName")));

        // same object -> returns true
        assertTrue(companyName.equals(companyName));

        // null -> returns false
        assertFalse(companyName.equals(null));

        // different types -> returns false
        assertFalse(companyName.equals(5.0f));

        // different values -> returns false
        assertFalse(companyName.equals(new CompanyName("Other Valid CompanyName")));
    }

}