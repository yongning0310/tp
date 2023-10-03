package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyInternshipBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;

/**
 * API of the Storage component
 */
public interface Storage extends InternshipBookStorage, UserPrefsStorage {

    @Override
    Optional<UserPrefs> readUserPrefs() throws DataLoadingException;

    @Override
    void saveUserPrefs(ReadOnlyUserPrefs userPrefs) throws IOException;

    @Override
    Path getInternshipBookFilePath();

    @Override
    Optional<ReadOnlyInternshipBook> readInternshipBook() throws DataLoadingException;

    @Override
    void saveInternshipBook(ReadOnlyInternshipBook internshipBook) throws IOException;

    @Override
    void saveInternshipBook(ReadOnlyInternshipBook internshipBook, Path filePath) throws IOException;
}
