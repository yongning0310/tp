---
    layout: default.md
    title: "User Guide"
    pageNav: 3
---

# Flagship User Guide

Flagship is a desktop app for managing internship applications, optimized for use via a [Command Line Interface](#glossary)
(CLI). There is always a swarm of information to keep track of every application season, and many people miss out on important deadlines
and valuable opportunities because information is not organised neatly. With Flagship, we want you to focus on preparing
for the interviews, and leave the application management to us.

Flagship has a host of awesome features that we are extremely proud of:
1. **Sorting** internships based on deadlines
2. **Filtering** internships based on interested roles
3. **Modifying** existing entries in accordance with updates

_... and many more!_

Our main target users are university students pursuing a computing-related degree. As such, this user guide (and Flagship in general)
is designed with the following assumptions in mind
1. You have a basic understanding of command line syntax
2. You are comfortable using the [command terminal](#glossary) to launch the application
3. You type fast and are love using the keyboard as the main tool of navigation

If these characteristics sound like you, Flagship can get your internship management tasks done faster than traditional GUI apps.

That said, do not get too intimidated as we have kept the launching process and commands as simple as possible. You
do not need prior knowledge of industry-level command line syntax to use this application effectively.


--------------------------------------------------------------------------------------------------------------------

## Using this guide

We understand that navigating an application for the first time can be incredibly intimidating. As such, we devised this
user guide to alert you to the main difficulties faced by new users, and inform you of the key features that you can utilise
in your internship management journey. Here is a rundown of how you can use this guide effectively

1. If you are running Flagship for the **first time**, start with our [Quick Start](#quick-start) section
2. If you want a **detailed breakdown** of how each command works, have a read of our [Commands Section](#commands).
2. If you are an **experienced Flagship user** who wants to have a quick check of the command syntax, jump
right to the [Command Summary](#command-summary).

## Common markers

Throughout the user guide, you will see these colored blocks of code that contain important information.

<div markdown="block" class="alert alert-success">
    💡 Green blocks contain tips to enhance your experience using Flagship.
</div>

<div markdown="block" class="alert alert-info">
    ℹ️ Blue blocks contain useful information to address doubts you might have.
</div>

<div markdown="span" class="alert alert-danger">
    ⚠️ Red blocks contain warnings that you must to heed so that Flagship works as intended.
</div>

<div style="page-break-after: always;"></div>

<!-- * Table of Contents -->
<page-nav-print />

## Glossary
* **[Command Line Interface (CLI)](https://en.wikipedia.org/wiki/Command-line_interface)** : A text-based interface where you can input commands to interact with the computer's programs
* **Command terminal**: A terminal is a text input and output environment. It is mainly used to launch the application for our purposes. Open your terminal by:
    * Searching and clicking `Command Prompt` on Windows
    * Searching and clicking `Terminal` on Mac and Linux (Ubuntu)
* **Parameters**: Parameters are additional information the command needs in order for it to perform its function successfully
* **JSON**: JSON is a lightweight format for storing and transporting data so that both humans and computers can easily read and understand it


--------------------------------------------------------------------------------------------------------------------

## Quick Start

Let's start tracking your internship applications right now!
1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `flagship.jar` from [here](https://github.com/AY2324S1-CS2103T-W17-1/tp/releases/tag/v1.3).

3. Copy the file to the folder you want to use as the _home folder_ for Flagship.

4. Open a command terminal, `cd` into the folder you put the jar file in, and use the `java -jar flagship.jar` command to run the application.<br>

    <div markdown="block" class="alert alert-info">
        ℹ️ Note that Flagship does not have any operating systems requirements and this process is the same regardless whether you use Windows or Mac!
    </div>

5. A GUI similar to the below should appear in a few seconds. Notice how we have already included some sample internship applications for you!<br>
   ![Ui](images/Ui.png)

6. Experiment with some commands within the input field and press <kbd>Enter</kbd> to execute it <br>

<div markdown="block" class="alert alert-success">
💡 Some example commands you can try: <br><br>

    # Creates an internship named `GovTech` to Flagship.
    create c/GovTech ro/SWE a/Yet to apply de/01/06/2022 s/20/01/2023 du/3 re/C++

    # Deletes the 3rd internship shown in the current list.
    delete 3

For the full list of executable commands, refer to the [Commands](#commands) Section.
</div>

--------------------------------------------------------------------------------------------------------------------

## Commands Format Notes

Flagship is powered by commands from your keyboard! All of our features can be accessed by executing various commands.

Here is the command format that will guide you keying in what is necessary for each command. We will be using the <kbd>create</kbd> command
of the following format `create c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS de/DEADLINE s/START_DATE du/DURATION [re/REQUIREMENT]...` as
an example.

- The **first word** describes the type of command you want to execute. For the above command, you are executing a <kbd>create</kbd> command.

- **Prefixes** such as <kbd>c/</kbd> serve as the labels for the [parameters](#glossary) in our commands.

- Parameters in <kbd>UPPER_CASE</kbd> are to be supplied by you. For the above command, you might input:

```
create c/GovTech ro/SWE a/Yet to apply de/25/12/2022 s/20/01/2023 du/3 re/C++
```
- **Parameters in square brackets <kbd>[]</kbd>** are optional and can be omitted. For the above command, you can choose not to input a single requirement.

```
create c/GovTech ro/SWE a/Yet to apply de/25/12/2022 s/20/01/2023 du/3
```
- **Parameters with <kbd>...</kbd> behind** can be used multiple times. For the above command, you can input many requirements.

```
create c/GovTech ro/SWE a/Yet to apply de/25/12/2022 s/20/01/2023 du/3 re/C++ re/Java
```

- Parameters can be entered in any order.
    - For instance, both `c/COMPANY_NAME ro/ROLE` and `ro/ROLE c/COMPANY_NAME` are valid.

## Parameter constraints

All of our parameters have certain constraints associated with them. Although they may seem cumbersome at first, these constraints
allow Flagship to help you detect typos and make retrieving data far easier!

| Parameter              | Prefix | Accepted Format                                                                                                                                   | Compulsory? | Example                               |
|------------------------|--------|---------------------------------------------------------------------------------------------------------------------------------------------------|-------------|---------------------------------------|
| **Company Name**       | `c/`   | **`COMPANY_NAME`** <br> `COMPANY_NAME` can contain these characters: `A-Z a-z 0-9 and space`. Cannot **exclusively** contain spaces.              | Yes         | `Optiver`, <br> `Jane Street`         |
| **Role**               | `ro/`  | **`ROLE`** <br> `ROLE` can contain these characters: `A-Z a-z 0-9 and space` Cannot **exclusively** contain spaces.                               | Yes         | `Software Engineer`, <br> `Fullstack` |
| **Application Status** | `a/`   | **`APPLICATION_STATUS`** <br> `APPLICATION_STATUS` must be one of the following `Yet to apply`, `Applied`, `In progress`, `Accepted`, `Rejected`. | Yes         | N.A                                   |
| **Deadline**           | `de/`  | **`DEADLINE`** <br> `DEADLINE` must be of the following form `DD/MM/YYYY` and must be **earlier** than the `START_DATE`.                          | Yes         | `20/02/2001`, <br> `01/01/2000`       |
| **Start Date**         | `s/`   | **`START_DATE`** <br> `START_DATE` must be of the following form `DD/MM/YYYY` and must be **later** than the `DEADLINE`.                          | Yes         | `20/02/2001`, <br> `01/01/2000`       |
| **Duration**           | `du/`  | **`DURATION`** <br> `DURATION` must be a positive integer.                                                                                        | Yes         | `1`, <br> `10`                        |
| **Requirements**       | `re/`  | **`REQUIREMENTS`** <br> `REQUIREMENTS` has no restrictions but cannot be empty                                                                    | No          | `C++`, <br> `Haskell`                 |

<div markdown="block" class="alert alert-info">
ℹ️ We understand that our constraints might be rigid in some cases. For example, it is possible for company names to contain
special characters. However, we believe that these cases are rare and loosening the parameter constraints will increase the
probability of typos and reduce the effectiveness of our filter functionalities.
</div>

--------------------------------------------------------------------------------------------------------------------

### Creating an Internship: `create`

Found an internship opportunity that you really want to apply for? Or have you submitted an internship application
and wish to keep tabs of its progress in the future? Create an internship entry that can be stored in Flagship so that
you will never lose track of it!

**Format**: `create c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS de/DEADLINE s/START_DATE du/DURATION [re/REQUIREMENTS]...`

**Example**: `create c/Citadel ro/Backend Developer a/Yet to apply de/01/02/2022 s/24/04/2022 du/2 re/C++`

**Interpretation**: Create an internship entry for **Citadel**. This is a **Backend Developer** role that you have
**yet to apply** for. The **deadline** for the application is 1 February 2022, and the internship is expected to **start**
on 24 April 2022. This is a **2-month** internship, and you are expected to be proficient in **C++**.

<div markdown="block" class="alert alert-success">
💡 Internship entries can have multiple requirements, or even none at all. However, all other attributes are compulsory!
</div>

<div markdown="span" class="alert alert-danger">
⚠️ Flagship does not allow you to create duplicate internship entries with the same company name or role. This makes sure
that you do not accidentally track an internship application twice. The following list below describes what constitutes identical entries.
</div>

| Description                                                                                     | Example                                                                   |
|-------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------|
| **Company name/role differs in initial letter capitalisation**                                  | `Jane Street`, `jane Street` and `jane street` are considered the same    |
| **Company name/role differs in leading/trailing white spaces** (Using dots to represent spaces) | `...Jane Street`, `Jane Street...`, `Jane Street` are considered the same |
| **Combination of initial letter capitalisation and leading/trailing white spaces**              | `Jane street...`, `...jane Street` are considered the same                |

**All other differences** between two internship entries' company name and role will cause them to be considered as distinct entries.

<div markdown="block" class="alert alert-info">
ℹ️ We do not allow you to create internship entries of different application status, duration, etc. but with the same
company name and role, because we believe that these cases are less likely to exist (but still possible!). If we loosen
our definition of identical internships further, Flagship will not be able to catch your accidental duplicate entries
as effectively.
</div>

### Editing an Internship: `modify`

Update details of an existing internship entry.

**Format**: `modify INDEX c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS s/START_DATE de/DEADLINE du/DURATION re/REQUIREMENTS...`

* Modify the internship at the specified `INDEX`. This index correlates with the position in the displayed internship list. It **must be a positive integer**, e.g., 1, 2, 3, …​.
* New inputs will overwrite existing values.
* Not all categories need to be specified.
* Categories that are not included will keep the previous values.
* Editing requirements will replace current requirements; adding requirements doesn't accumulate.
* Use the command without `re/` to remove all of an internship's requirements.

**Examples**:
* `modify 1 c/Jane Street ro/Coffee maker a/Yet to apply s/20/01/2023 de/29/11/2022 du/3 re/C++ re/Coffee`

### Filter Internships by Category and Keyword/Range: `filter`

Want to focus only on relevant internship entries based on certain constraints? Filter internship entries by inputting any category. There are 2 category types: type 1 accepting text inputs and type 2 accepting a range of values. The category types are as follows:

* Category type 1: company name, role, requirements
* Category type 2: duration, deadline

Format 1: `filter [CATEGORY_TYPE1]/[KEYWORD]`

<div markdown="block" class="alert alert-success">
ℹ️ The search isn't case-sensitive. For instance, `hans` matches `Hans`.
</div>

Examples:
* `filter c/JA ro/SWE` displays internships with company names containing "JA" and roles containing "SWE".

Format 2: `filter [CATEGORY_TYPE2]/[START-END]`

<div markdown="block" class="alert alert-info">
ℹ️ Flagship only allows filter by range for this category type. To filter for one value, you can input the range as VALUE-VALUE.
</div>

Examples:
* `filter du/3-6` displays internship entries that have duration within the range 3 to 6 inclusive.


Format 3: `filter default`

Examples: 
* `filter default` lists all internship entries.

<div markdown="block" class="alert alert-success">
💡 If you execute a new filter command, it supersedes the previous filter. Otherwise, the initial filter remains active.
</div>

**Expected Output**:
![Filter](images/filterAnnotated.jpg)

### Sort Internships by Category and Order: `sort`

Have a growing list of internships and finding it challenging to prioritize? Or perhaps you're looking to identify opportunities with the nearest deadlines or those that align with a specific field of interest? Use the sort feature in Flagship to organize and arrange your internship list based on specific categories and order.

**Format**: `sort [CATEGORY]/[ASC/DESC]`

* `ASC` indicates ascending order, and `DESC` denotes descending order.

**Examples**:
* `sort c/ASC` sorts entries by company name (ascending).
* `sort default` resets the list to default, which is in order of company name (ascending).

<div markdown="block" class="alert alert-success">
💡 Internship entries are by default sorted by company name in ascending order.
</div>
<div markdown="block" class="alert alert-info">
ℹ️ We do not allow you to stack sorts. A subsequent `sort` command will replace the prior one. Otherwise, the initial sort remains effective.
</div>

**Expected Output**:
![Sort](images/Sort.jpg)

### Deleting an Internship: `delete`

Remove a specified internship from the internship directory.

**Format**: `delete INDEX`

* Erase the internship at the designated `INDEX`.
* The index corresponds to the position in the displayed internship list.
* The index **must be a positive integer** like 1, 2, 3, …​

**Examples**:
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

InternshipBook data are saved automatically as a [JSON](#glossary) file `[JAR file location]/data/internship.json`. Advanced users are welcome to update data directly by editing that data file.

<box type="warning" seamless></box>

**Caution:**
If your changes to the data file makes its format invalid, InternshipBook will discard all data and start with an empty data file at the next run.  Hence, it is recommended to take a backup of the file before editing it.
</box>

[//]: # (### Archiving data files `[coming in v2.0]`)

[//]: # ()
[//]: # (_Details coming soon ..._)

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous InternshipBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Known issues

1. **When using multiple screens**, if you move the application to a secondary screen, and later switch to using only the primary screen, the GUI will open off-screen. The remedy is to delete the `preferences.json` file created by the application before running the application again.

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action     | Format, Examples                                                                                                                                                                                                                                 |
|------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| **Create** | `create c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS de/DEADLINE s/START_DATE du/DURATION re/REQUIREMENTS...​` <br> e.g., `create c/Jane Street ro/Coffee maker a/Yet to apply de/15/12/2022 s/20/01/2023 du/3 re/C++ re/Coffee`                  |
| **Modify** | `modify INDEX c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS s/START_DATE de/DEADLINE du/DURATION re/REQUIREMENTS...` <br> e.g., `modify INDEX c/COMPANY_NAME ro/ROLE a/APPLICATION_STATUS s/START_DATE de/DEADLINE du/DURATION re/REQUIREMENTS...` |
| **Filter** | `filter [category]/[keyword] ...` <br> e.g.,   `filter c/JA ro/SWE`                                                                                                                                                                              |
| **Sort**   | `sort [CATEGORY]/[ASC/DESC]` <br> e.g.,  `sort de/ASC`                                                                                                                                                                                           |
| **Delete** | `delete INDEX`<br> e.g., `delete 2`                                                                                                                                                                                                              |

[//]: # (**List**   | `list`)

[//]: # (**Help**   | `help`)


