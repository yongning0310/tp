package seedu.address.model.requirement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RequirementTest {

    @Test
    public void constructor_nullRequirementName_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Requirement(null));
    }

    @Test
    public void constructor_invalidRequirementName_throwsIllegalArgumentException() {
        String invalidRequirementName = ""; // An empty string
        assertThrows(IllegalArgumentException.class, () ->
                new Requirement(invalidRequirementName));
    }

    @Test
    public void isValidRequirementName_validRequirementName_returnsTrue() {
        assertTrue(Requirement.isValidRequirementName("Maths Requirement"));
    }

    @Test
    public void isValidRequirementName_invalidRequirementName_returnsFalse() {
        assertFalse(Requirement.isValidRequirementName("   ")); // Only spaces
        assertFalse(Requirement.isValidRequirementName("")); // Empty string
    }

    @Test
    public void equals_sameObject_returnsTrue() {
        Requirement requirement = new Requirement("English Requirement");
        assertTrue(requirement.equals(requirement));
    }

    @Test
    public void equals_sameValues_returnsTrue() {
        Requirement requirement1 = new Requirement("Science Requirement");
        Requirement requirement2 = new Requirement("Science Requirement");
        assertTrue(requirement1.equals(requirement2));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        Requirement requirement1 = new Requirement("Arts Requirement");
        Requirement requirement2 = new Requirement("Tech Requirement");
        assertFalse(requirement1.equals(requirement2));
    }

    @Test
    public void hashCode_sameRequirementName_sameHashCode() {
        Requirement requirement1 = new Requirement("History Requirement");
        Requirement requirement2 = new Requirement("History Requirement");
        assertEquals(requirement1.hashCode(), requirement2.hashCode());
    }

    @Test
    public void toString_validRequirementName_correctFormat() {
        Requirement requirement = new Requirement("Physics Requirement");
        assertEquals("[Physics Requirement]", requirement.toString());
    }
}
