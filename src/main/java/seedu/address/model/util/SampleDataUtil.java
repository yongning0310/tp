package seedu.address.model.util;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.AddressBook;
import seedu.address.model.InternshipBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyInternshipBook;
import seedu.address.model.internship.*;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.requirement.Requirement;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                new Address("Blk 30 Geylang Street 29, #06-40"),
                getTagSet("friends")),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                getTagSet("colleagues", "friends")),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                getTagSet("neighbours")),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                getTagSet("family")),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                new Address("Blk 47 Tampines Street 20, #17-35"),
                getTagSet("classmates")),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                new Address("Blk 45 Aljunied Street 85, #11-31"),
                getTagSet("colleagues"))
        };
    }

    public static Internship[] getSampleInternships() {
        return new Internship[] {
                new Internship(new CompanyName("Google"), new Role("SWE Intern"),
                        new ApplicationStatus("Applied"), new StartDate("20/01/2023"),
                        new Duration("3"), getRequirementSet("Java", "Python")),
                new Internship(new CompanyName("Facebook"), new Role("Research Intern"),
                        new ApplicationStatus("Yet to apply"), new StartDate("15/02/2023"),
                        new Duration("4"), getRequirementSet("Machine Learning", "Python")),
                new Internship(new CompanyName("Microsoft"), new Role("DevOps Intern"),
                        new ApplicationStatus("Accepted"), new StartDate("01/03/2023"),
                        new Duration("6"), getRequirementSet("Azure", "Shell Scripting")),
                new Internship(new CompanyName("Amazon"), new Role("Web Development Intern"),
                        new ApplicationStatus("Rejected"), new StartDate("01/04/2023"),
                        new Duration("2"), getRequirementSet("React", "Node.js")),
                new Internship(new CompanyName("Netflix"), new Role("Data Science Intern"),
                        new ApplicationStatus("In progress"), new StartDate("10/03/2023"),
                        new Duration("5"), getRequirementSet("Python", "Statistics")),
        };
    }

    public static ReadOnlyInternshipBook getSampleInternshipBook() {
        InternshipBook sampleIb = new InternshipBook();
        for (Internship sampleInternship : getSampleInternships()) {
            sampleIb.addInternship(sampleInternship);
        }
        return sampleIb;
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }


    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

    public static Set<Requirement> getRequirementSet(String... strings) {
        return Arrays.stream(strings)
                .map(Requirement::new)
                .collect(Collectors.toSet());
    }

}
