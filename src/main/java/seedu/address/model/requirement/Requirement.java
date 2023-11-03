package seedu.address.model.requirement;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Requirement in Flagship.
 * Guarantees: immutable; name is valid as declared in {@link #isValidRequirementName(String)}
 */
public class Requirement {

    public static final String MESSAGE_CONSTRAINTS = "Requirements cannot be empty";
    public static final String VALIDATION_REGEX = ".+\\S.+";

    private final String requirementName;

    /**
     * Constructs a {@code Requirement}.
     *
     * @param requirementName A valid requirement name.
     */
    public Requirement(String requirementName) {
        requireNonNull(requirementName);
        checkArgument(isValidRequirementName(requirementName), MESSAGE_CONSTRAINTS);
        this.requirementName = requirementName;
    }

    /**
     * Verifies whether the given string constitutes a valid requirement.
     *
     * @param test The given string to be tested.
     * @return A boolean representing whether the string input is valid.
     */
    public static boolean isValidRequirementName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Requirement)) {
            return false;
        }

        Requirement otherRequirement = (Requirement) other;
        return this.requirementName.equals(otherRequirement.requirementName);
    }

    @Override
    public int hashCode() {
        return this.requirementName.hashCode();
    }

    /**
     * Returns the raw string value of the Internship's requirement. This method is used exclusively by the filter
     * command. We have both a toString() method and a getRequirementName() method to guard against any potential
     * changes to the toString() string output that will regress the functionalities of filter.
     *
     * @return The raw string value of the Internship's requirement.
     */
    public String getRequirementName() {
        return this.requirementName;
    }

    /**
     * Returns an accessorised string output to represent the internship's requirement.
     */
    public String toString() {
        return '[' + this.requirementName + ']';
    }
}
