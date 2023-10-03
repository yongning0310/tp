package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class Remark {
    public final String value;

    public static final String MESSAGE_CONSTRAINTS = "Remarks should not be empty";

    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    /**
     * Returns if a given string is a valid remark.
     */
    public static boolean isValidRemark(String test) {
        return true;
    }


    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Remark
                && value.equals(((Remark) other).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public Remark setRemark(String remark) {
        return new Remark(remark);
    }
}