package seedu.address.model.internship;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Arrays;
import java.util.List;



/**
 * Represents an Internship's application status in Flagship.
 * Guarantees: immutable; is valid as declared in {@link #isValidApplicationStatus(String)}
 */
public class ApplicationStatus implements Comparable<ApplicationStatus> {
    public static final String MESSAGE_CONSTRAINTS =
            "Application Status cannot be blank and should only contain one of the following: "
                    + "Yet to apply, Applied, In progress, Accepted, Rejected";

    private static final List<String> VALID_STATUSES = Arrays.asList(
            "Yet to apply", "Applied", "In progress", "Accepted", "Rejected"
    );

    private final String applicationStatus;

    /**
     * Constructs a {@code ApplicationStatus}.
     *
     * @param applicationStatus A valid application status.
     */
    public ApplicationStatus(String applicationStatus) {
        requireNonNull(applicationStatus);
        checkArgument(isValidApplicationStatus(applicationStatus), MESSAGE_CONSTRAINTS);
        this.applicationStatus = applicationStatus;
    }

    public static boolean isValidApplicationStatus(String test) {
        return VALID_STATUSES.contains(test);
    }

    @Override
    public String toString() {
        return this.applicationStatus;
    }

    public String getApplicationStatus() {
        return this.applicationStatus;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof ApplicationStatus)) {
            return false;
        }

        ApplicationStatus otherApplicationStatus = (ApplicationStatus) other;
        return this.applicationStatus.equals(otherApplicationStatus.applicationStatus);
    }

    @Override
    public int hashCode() {
        return this.applicationStatus.hashCode();
    }

    @Override
    public int compareTo(ApplicationStatus other) {
        return this.applicationStatus.compareTo(other.applicationStatus);
    }
}
