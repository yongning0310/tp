package seedu.address.model.internship;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.InternshipBuilder;

/**
 * Contains tests for {@code RoleContainsKeywordsPredicate}.
 * This class is responsible for testing the behavior of {@link RoleContainsKeywordsPredicate}
 * to ensure that it correctly identifies if an {@code Internship}'s {@code Role} matches any
 * of the given keywords.
 *
 * @see RoleContainsKeywordsPredicate
 */
public class RoleContainsKeywordsPredicateTest {
    @Test
    public void equals_sameObject_returnsTrue() {
        RoleContainsKeywordsPredicate predicate = new RoleContainsKeywordsPredicate(Collections
                .singletonList("Software"));
        assertTrue(predicate.equals(predicate));
    }

    @Test
    public void equals_sameValues_returnsTrue() {
        RoleContainsKeywordsPredicate firstPredicate = new RoleContainsKeywordsPredicate(Collections
                .singletonList("Software"));
        RoleContainsKeywordsPredicate secondPredicate = new RoleContainsKeywordsPredicate(Collections
                .singletonList("Software"));

        assertTrue(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void equals_differentTypes_returnsFalse() {
        RoleContainsKeywordsPredicate predicate = new RoleContainsKeywordsPredicate(Collections
                .singletonList("Software"));
        assertFalse(predicate.equals(1));
    }

    @Test
    public void equals_null_returnsFalse() {
        RoleContainsKeywordsPredicate predicate = new RoleContainsKeywordsPredicate(Collections
                .singletonList("Software"));
        assertFalse(predicate.equals(null));
    }

    @Test
    public void equals_differentValues_returnsFalse() {
        RoleContainsKeywordsPredicate firstPredicate = new RoleContainsKeywordsPredicate(
                Arrays.asList("Software", "Engineer"));
        RoleContainsKeywordsPredicate secondPredicate = new RoleContainsKeywordsPredicate(
                Arrays.asList("Data", "Scientist"));

        assertFalse(firstPredicate.equals(secondPredicate));
    }

    @Test
    public void test_roleContainsKeywords_returnsTrue() {
        // One keyword
        List<String> keywords = Collections.singletonList("Engineer");
        RoleContainsKeywordsPredicate predicate = new RoleContainsKeywordsPredicate(keywords);
        Internship internship = new InternshipBuilder().withRole("Software Engineer").build();
        assertTrue(predicate.test(internship));

        // Multiple keywords
        keywords = Arrays.asList("Software", "Engineer");
        predicate = new RoleContainsKeywordsPredicate(keywords);
        assertTrue(predicate.test(internship));

        // Only one matching keyword
        keywords = Arrays.asList("Software", "Manager");
        predicate = new RoleContainsKeywordsPredicate(keywords);
        assertTrue(predicate.test(internship));
    }

    @Test
    public void test_roleDoesNotContainKeywords_returnsFalse() {
        // Zero keywords
        List<String> keywords = Collections.emptyList();
        RoleContainsKeywordsPredicate predicate = new RoleContainsKeywordsPredicate(keywords);
        Internship internship = new InternshipBuilder().withRole("Software Engineer").build();
        assertFalse(predicate.test(internship));

        // Non-matching keyword
        keywords = Collections.singletonList("Manager");
        predicate = new RoleContainsKeywordsPredicate(keywords);
        assertFalse(predicate.test(internship));

        // Keywords match name, but not role
        keywords = Arrays.asList("Jane", "Street");
        predicate = new RoleContainsKeywordsPredicate(keywords);
        assertFalse(predicate.test(internship));
    }

    // Additional tests can be added to further check for edge cases or other behaviors.
}