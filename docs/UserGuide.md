---
  layout: default.md
  title: "User Guide"
  pageNav: 3
---

# FlagShip User Guide

FlagShip is a **desktop app for managing internships, optimized for use via a  Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, FlagShip can get your internship management tasks done faster than traditional GUI apps.

<!-- * Table of Contents -->
<page-nav-print />

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `internshipBook.jar` from [here](https://github.com/se-edu/internshipBook/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your InternshipBook.

1. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar internshipBook.jar` command to run the application.<br>
   A GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * `create c/Jane Street ro/Coffee maker a/Yet to apply de/25/12/2022 s/20/01/2023 du/3 re/C++ re/Coffee` : Creates an internship named `Jane Street` to Flagship.

   * `delete 3` : Deletes the 3rd internship shown in the current list.

   * `modify 2 c/Jane Street ro/Coffee maker` : Modify the 2nd internship shown in current list with new company 
   and new role.

   * `sort c/ASC ro/DESC` : Arrange the internships by company name in ascending order, then by 
   role in descending order.

   * `filter c/Ja ro/SWE` : Display only internships from companies with the name containing "Ja" and 
   roles that include "SWE".


1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<box type="info" seamless>

## Command Format Notes:

- **Parameters in `UPPER_CASE`**: These indicate the values to be supplied by the user.
    - Example: For the command `create c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS de/DEADLINE s/START_DATE du/DURATION re/REQUIREMENTS`, you might input:
      ```
      create c/Jane Street ro/Coffee maker a/Yet to apply de/25/12/2022 s/20/01/2023 du/3 re/C++ re/Coffee
      ```

- **Compulsory Parameters**: Some parameters must be provided.
    - `c/` → `COMPANY_NAME`: Cannot be left blank.
    - `ro/` → `ROLE`: Cannot be left blank.
    - `de/` → `DEADLINE`: Required, formatted as dd/mm/yyyy.
    - `s/` → `START_DATE`: Required, formatted as dd/mm/yyyy.
    - `du/` → `DURATION`: Required, a positive integer representing the number of months.

- **Optional Parameters**:
    - `re/` → Requirements are not mandatory. You can specify multiple requirements.

- **Parameter Order**: Parameters can be entered in any order.
    - For instance, both `c/COMPANY_NAME ro/ROLE` and `ro/ROLE c/COMPANY_NAME` are valid.

[//]: # (- **Commands Without Parameters**: Some commands do not require parameters. Additional parameters for these commands will be ignored.)

[//]: # (    - Example: Using `help 123` will simply be interpreted as `help`.)

> Tip: If you're referencing a PDF version of this guide, be cautious when copying multi-line commands. Ensure no spaces or line-breaks are omitted when pasting into the application.

</box>


[//]: # (### Viewing help : `help`)

[//]: # ()
[//]: # (Shows a message explaning how to access the help page.)

[//]: # ()
[//]: # (![help message]&#40;images/helpMessage.png&#41;)

[//]: # ()
[//]: # (Format: `help`)

### Creating an Internship: `create`

Add an internship entry to Flagship.

Format: `create c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS s/START_DATE de/DEADLINE du/DURATION re/REQUIREMENTS...`


**Tip:** Internships can have multiple requirements, or even none at all.
</box>

Examples:
* `create c/Jane Street ro/Coffee maker a/Yet to apply s/20/01/2023 de/15/12/2022 du/3 re/C++ re/Coffee`
* `create c/Citadel ro/Coffee pourer a/Applied s/24/04/2022 de/29/11/2022 du/1`

### Editing an Internship: `modify`

Update details of an existing internship entry.

Format: `modify INDEX c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS s/START_DATE de/DEADLINE du/DURATION re/REQUIREMENTS...`

* Modify the internship at the specified `INDEX`. This index correlates with the position in the displayed internship list. It **must be a positive integer**, e.g., 1, 2, 3, …​.
* New inputs will overwrite existing values.
* Categories that are not included will keep the previous values.
* Editing requirements will replace current requirements; adding requirements doesn't accumulate.
* Use the command without `re/` to remove all of an internship's requirements.

Examples:
* `modify 1 c/Jane Street ro/Coffee maker a/Yet to apply s/20/01/2023 de/29/11/2022 du/3 re/C++ re/Coffee`

### Filter Internships by Name and Keyword: `filter`

Display internships matching specific category keywords.

Format: `filter [category]/[keyword] ...`

* The search isn't case-sensitive. For instance, `hans` matches `Hans`.
* The sequence of category and keyword doesn't matter.
* Results will include internships matching all keywords (i.e., `AND` search). For instance, `c/JA ro/SWE` matches `c/JANE STREET and ro/SWE` but not `c/JANE STREET ro/Admin` or `c/Google ro/SWE`.
* If you execute a new filter command, it supersedes the previous filter. Otherwise, the initial filter remains active.

Examples:
* `filter c/JA ro/SWE` displays internships with company names containing "JA" and roles containing "SWE".
* `filter` returns the list to its unfiltered state.

### Sort Internships by Category and Order: `sort`

Organize the displayed list based on specific categories and order.

Format: `sort [category]/[ASC/DESC]`

* `ASC` indicates ascending order, and `DESC` denotes descending order.
* A subsequent `sort` command will replace the prior one. Otherwise, the initial sort remains effective.

Examples:
* `sort c/ASC` sorts entries by company name (ascending).
* `sort` resets the list to default, which is in order of creation (ascending).

### Deleting an Internship: `delete`

Remove a specified internship from the internship directory.

Format: `delete INDEX`

* Erase the internship at the designated `INDEX`.
* The index corresponds to the position in the displayed internship list.
* The index **must be a positive integer** like 1, 2, 3, …​

Examples:
* `delete 2` removes the 2nd internship from the directory.
* Running `sort c/ASC ro/DESC` followed by `delete 1` erases the top internship post-sort.


[//]: # (### Clearing all entries : `clear`)

[//]: # ()
[//]: # (Clears all entries from the address book.)

[//]: # ()
[//]: # (Format: `clear`)

[//]: # ()
[//]: # (### Exiting the program : `exit`)

[//]: # ()
[//]: # (Exits the program.)

[//]: # ()
[//]: # (Format: `exit`)

### Saving the data

InternshipBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Editing the data file

InternshipBook data are saved automatically as a JSON file `[JAR file location]/data/internship.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless></box>

**Caution:**
If your changes to the data file makes its format invalid, InternshipBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>

### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous InternshipBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action     | Format, Examples
-----------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Create** | `create c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS s/START_DATE de/DEADLINE du/DURATION re/REQUIREMENTS...​` <br> e.g., `create c/Jane Street ro/Coffee maker a/Yet to apply s/20/01/2023 de/15/12/2022 du/3 re/C++ re/Coffee`
**Modify**  | `modify INDEX c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS s/START_DATE de/DEADLINE du/DURATION re/REQUIREMENTS...` <br> e.g., `modify INDEX c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS s/START_DATE de/DEADLINE du/DURATION re/REQUIREMENTS...`
**Filter** | `filter [category]/[keyword] ...` <br> e.g.,   `filter c/JA ro/SWE`
**Sort**   | `sort [category]/[ASC/DESC]` <br> e.g.,  `sort de/ASC` 
**Delete**   | `delete INDEX`<br> e.g., `delete 2`

[//]: # (**List**   | `list`)

[//]: # (**Help**   | `help`)


