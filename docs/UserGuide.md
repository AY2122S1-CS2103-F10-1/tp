---
layout: page
title: User Guide
---

MrTechRecruiter (MTR) is a **desktop app for managing job applications, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, MTR can get your application management tasks done faster than traditional GUI apps.

* Table of Contents
  {:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start (coming soon)

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `mrtechrecruiter.jar` from [here](https://github.com/AY2122S1-CS2103-F10-1/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for MrTechRecruiter.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all applicants.

   * **`add-applicant`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 pos/software engineer` : Adds an applicant named `John Doe` to the `software engineer` position.

   * **`delete-applicant`**`n/John Doe` : Deletes `John Doe` from the applicant list.

   * **`clear`** : Deletes all applicants.

    * **`exit`** : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter should only appear once in the command but is specified multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `list`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>

### Viewing help : `help` `[coming soon]`

Shows a message explaining how to access the help page.

Format: `help`

### Adding a position: `add-position`

Adds a position to MrTechRecruiter.

Format: `add-position tit/TITLE des/DESCRIPTION`

Examples:
* `add-position tit/software engineer des/work in a team that builds a facial recognition application`


### Editing a position: `edit-position`

Edits the specified position in MrTechRecruiter.

Format: `edit-position INDEX tit/NEWTITLE des/NEWDESCRIPTION`

* Edit the position with the specified `INDEX`

Examples: 
* `edit-position INDEX tit/Algorithm Engineer des/embed algorithms into the facial recognition application `


### Deleting a position: `delete-position`

Deletes the specified position from MrTechRecruiter.

Format: `delete-position INDEX`

* Deletes the position with the specified `INDEX`.

Examples:
* `delete-position 1` deletes the position with index 1.


### Adding an applicant: `add-applicant`

Adds an applicant to MrTechRecruiter.

Format: `add-applicant n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS pos/POSITION​`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
An applicant should only have 1 position. <br>
If the job position exists, its rejection rate should update accordingly.
</div>

Examples:
* `add-applicant n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01 pos/software engineer`
* `add-applicant n/Betsy Crowe e/betsycrowe@example.com a/Newgate Prison p/1234567 pos/database administrator`


### Editing an applicant: `edit-applicant`
Edits the specified applicant in MrTechRecruiter

Format: `edit-applicant INDEX n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS pos/POSITION` 

* Edit the applicant with the specified `INDEX`
* The `position` must have been added to MrTechRecruiter

Examples:
* `edit-applicant n/Jasmine Doe p/98761432 e/johnd@example.com`
* `edit-applicant n/Betsy p/1234567 pos/database administrator`


### Deleting an applicant: `delete-applicant`

Deletes the specified applicant from MrTechRecruiter.

Format: `delete-applicant INDEX`

* Deletes the applicant with the specified `INDEX`.

Examples:
* `delete-applicant 1` deletes the applicant with index 1.


### Listing all positions : `list-position` 

Shows a list of all positions in MrTechRecruiter.

Format: `list-position`


### Listing all applicants : `list-applicant` 

Shows a list of all applicants in MrTechRecruiter.

Format: `list-applicant`


### Get rejection rate of a specified position : `rate`

Shows the rejection rate of an existing position in MrTechRecruiter.

Format: `rate pos/POSITION`

* If specified `POSITION` does not exist, will display a different message.
* If the `POSITION` has no applicants, will display a `No current applicants` message.

Examples:
* `rate pos/software engineer`

### Undoing the last modification : `undo`

Recovers the state before last modification is made.
The modification command includes: `add-position` `add-applicant` `edit-position` `edit-applicant` `delete-position` `delete-applicant`
`` [command that modifies the state should also be added later]

Format: `undo`

### Filtering applicants: `filter-applicant`

Filter the list of applicants by specific criteria.

Format: `filter-applicant [pos/POSITION] [status/STATUS]​`

* The position filter is case-sensitive. e.g `software engineer` will not match `Software Engineer`
* The status filter is case-insensitive. e.g. `accepted` or `ACCEPTED` will both match the `"Accepted"` application status.
* A variable number of filters can be specified.
* The filtering uses a logical `AND`. e.g. `filter-applicant pos/software engineer status/accepted` will match all applicants applying to the `software engineer` position AND with application status `"Accepted"`.
* Consecutive calls are independent of one another (i.e. the filters do not stack).

Examples:
* `filter-applicant status/rejected` displays a list of all rejected applicants.
* `filter-applicant pos/database administrator status/accepted` displays a list of all applicants to the `database administrator` position, that have been accepted.

### Visualizing a position with a pie chart: `visualize`

Displays a pie chart breakdown of a position and the statuses of its applicants.
Hovering over a pie chart slice will display its percentage value. 

Format: `visualize POSITION_TITLE​`

* `POSITION_TITLE` is case-insensitive. e.g. `visualize software engineer` will display the pie chart for the position `SOFTWARE ENGINEER`.


### Searching for applicants using keywords: `find` [coming soon]

Finds all applicants whose categorical information match the specified search terms.

Format: `find [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`

* The search is case-insensitive. e.g `hans` will match `Hans`
* Only applicants matching ALL specified search terms specified will be returned.

Examples:
* `find n/John` returns `john` and `John Doe`
* `find n/Mary p/12345678` returns applicants whose names contain `mary` AND whose numbers contain `12345678`


### Clearing all entries : `clear` `[coming soon]`

Clears all entries from MrTechRecruiter.

Format: `clear`


### Exiting the program : `exit` `[coming soon]`

Exits the program.

Format: `exit`


### Saving the data

All data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


### Editing the data file

Data is saved as a JSON file `[JAR file location]/data/POSITION-TITLE.json`. Advanced users are welcome to update data directly by editing that data file.

<div markdown="span" class="alert alert-warning">:exclamation: **Caution:**
If your changes to the data file makes its format invalid, MrTechRecruiter will discard all data and start with an empty data file at the next run.
</div>

### Viewing command history
Using the up and down arrow keys, you can navigate your command history to view your most recent commands.


### Archiving data files `[coming in v2.0]`

_Details coming soon ..._

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous MrTechRecruiter home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

Action | Format, Examples
--------|------------------
**Add Applicant** | `add-applicant n/NAME p/PHONE_NUMBER e/EMAIL a/ADDRESS pos/POSITION` <br> e.g., `add-applicant n/James Ho p/22224444 e/jamesho@example.com a/123, Clementi Rd, 1234665 pos/software engineer`
**Delete Applicant** | `delete-applicant n/NAME`<br> e.g., `delete-applicant John Doe`
**Clear [coming soon]** | `clear`
**Edit [coming soon]** | `edit INDEX [n/NAME] [p/PHONE_NUMBER] [e/EMAIL] [a/ADDRESS] [t/TAG]…​`<br> e.g.,`edit 2 n/James Lee e/jameslee@example.com`
**Filter Applicants** | `filter-applicant [pos/POSITION] [status/STATUS]​`<br> e.g., `filter-applicant pos/software engineer status/accepted`
**Visualize Positions** | `visualize POSITION_TITLE​`<br> e.g., `visualize database administrator`
**Find** | `find KEYWORD [MORE_KEYWORDS]`<br> e.g., `find James Jake`
**List [coming soon]** | `list`
**Help [coming soon]** | `help`
**Rate | `rate pos/POSITION` <br> e.g. `rate software engineer`
