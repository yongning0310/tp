package seedu.address.model;

import java.nio.file.Path;

import seedu.address.commons.core.GuiSettings;

// THIS FILE WILL BE REMOVED EVENTUALLY

/**
 * Unmodifiable view of user prefs.
 */
public interface ReadOnlyUserPrefs {

    GuiSettings getGuiSettings();

    Path getAddressBookFilePath();

}
