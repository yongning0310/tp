package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.InternshipBuilder.DEFAULT_APPLICATION_STATUS;
import static seedu.address.testutil.InternshipBuilder.DEFAULT_COMPANY_NAME;
import static seedu.address.testutil.InternshipBuilder.DEFAULT_DEADLINE;
import static seedu.address.testutil.InternshipBuilder.DEFAULT_DURATION;
import static seedu.address.testutil.InternshipBuilder.DEFAULT_ROLE;
import static seedu.address.testutil.InternshipBuilder.DEFAULT_START_DATE;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.model.internship.Internship;
import seedu.address.testutil.InternshipBuilder;

public class InternshipCardTest {

    private Internship validInternship;
    private InternshipCard internshipCard;

    @BeforeEach
    public void setUp() {
        Internship validInternship = new InternshipBuilder().build();
        internshipCard = new InternshipCard(validInternship, 1);
    }

    @Test
    public void testInternshipCardDisplay() {
        assertEquals(validInternship.getCompanyName().toString(), DEFAULT_COMPANY_NAME);
        assertEquals(validInternship.getRole().toString(), DEFAULT_ROLE);
        assertEquals(validInternship.getApplicationStatus().toString(), DEFAULT_APPLICATION_STATUS);
        assertEquals(validInternship.getStartDate().toString(), DEFAULT_START_DATE);
        assertEquals(validInternship.getDuration().toString(), DEFAULT_DURATION);
        assertEquals(validInternship.getDeadline().toString(), DEFAULT_DEADLINE);
    }
}
