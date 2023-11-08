package seedu.address.model.internship;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents an Internship's role in Flagship.
 * Guarantees: immutable; is valid as declared in {@link #isValidRole(String)}
 */
public class Role implements Comparable<Role> {

    public static final String MESSAGE_CONSTRAINTS = "The role should fulfill all the following conditions:\n"
            + "1. Contains only english alphanumeric characters and spaces\n"
            + "2. Should not be blank\n"
            + "3. Cannot be longer than 200 characters";

    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    private final String role;

    /**
     * Constructs a {@code Role}.
     *
     * @param role A valid role.
     */
    public Role(String role) {
        requireNonNull(role);
        checkArgument(isValidRole(role), MESSAGE_CONSTRAINTS);
        this.role = role;
    }

    /**
     * Verifies whether the given string constitutes a valid role. Roles longer than 200 characters are rejected to
     * prevent overflows in the UI.
     *
     * @param test The given string to be tested.
     * @return A boolean representing whether the string input is valid.
     */
    public static boolean isValidRole(String test) {
        if (test.length() > 200) {
            return false;
        }
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return this.role;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Role)) {
            return false;
        }

        Role otherRole = (Role) other;
        return this.role.equalsIgnoreCase(otherRole.role);
    }

    /**
     * Returns the raw string value of the Internship's role. This method is used exclusively by the filter command.
     * We have both a toString() method and a getRole() method to guard against any potential changes to the
     * toString() string output that will regress the functionalities of filter.
     *
     * @return The raw string value of the Internship's role.
     */
    public String getRole() {
        return this.role;
    }

    @Override
    public int hashCode() {
        return this.role.hashCode();
    }

    @Override
    public int compareTo(Role other) {
        return this.role.compareToIgnoreCase(other.role);
    }
}
