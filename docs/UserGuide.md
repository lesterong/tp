---
layout: page
title: User Guide
---

NUScheduler is a desktop app for **managing contacts, optimised for use via a Command Line Interface (CLI)** while still having the benefits of a Graphical User Interface (GUI). If you can type fast, NUScheduler can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `NUScheduler.jar` from [here](https://github.com/AY2223S1-CS2103T-T17-3/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your NUScheduler.

4. Double-click the file to start the app.

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`profile -a`** : Adds profile.

   * **`profile -d `**`2` : Deletes the 2nd profile shown in the current list.

   * **`profile -v`** : Lists all profiles in NUScheduler.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the command format:**<br>

* Words in `UPPER_CASE` are the parameters to be supplied by the user.<br>
  e.g. in `add n/NAME`, `NAME` is a parameter which can be used as `add n/John Doe`.

* Items in square brackets are optional.<br>
  e.g `n/NAME [t/TAG]` can be used as `n/John Doe t/friend` or as `n/John Doe`.

* Items with `…`​ after them can be used multiple times including zero times.<br>
  e.g. `[t/TAG]…​` can be used as ` ` (i.e. 0 times), `t/friend`, `t/friend t/family` etc.

* For `Event` and `Profile` commands, option flags (`-x` where `x` is a placeholder for valid flags e.g. `a`, `d`, `v`) must be used after the `event` and `profile` command word

* The other parameters can be in any order.<br>
  e.g. if the command specifies `n/NAME p/PHONE_NUMBER`, `p/PHONE_NUMBER n/NAME` is also acceptable.

* If a parameter is expected only once in the command, but you specified it multiple times, only the last occurrence of the parameter will be taken.<br>
  e.g. if you specify `p/12341234 p/56785678`, only `p/56785678` will be taken.

* Extraneous parameters for commands that do not take in parameters (such as `help`, `exit` and `clear`) will be ignored.<br>
  e.g. if the command specifies `help 123`, it will be interpreted as `help`.

</div>



### Viewing help: `help`

Opens a help window displaying all the recognised commands, and a link to access the user guide.

![help message](images/helpMessage.png)

Format: `help`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
Open the help window using <kbd>F1</kbd> on your keyboard
</div>

### Adding a profile: `profile -a`

Adds a profile to NUScheduler.

Format: `profile -a n/NAME p/PHONE_NUMBER e/EMAIL [tg/TELEGRAM_USERNAME] [t/TAG]…`

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
A profile can have 0 or more tags.
</div>

Examples:
* `profile -a n/John Doe p/98765432 e/johnd@u.nus.edu t/friend`
* `profile -a n/Jane Smith e/jane_s@u.nus.edu p/91234580 tg/jane_s`
* `profile -a n/Betsy Crowe e/betsycrowe@u.nus.edu p/1234567 t/professor t/lecturer`

### Viewing all profiles: `profile -v`

Shows a list of all profiles in the NUScheduler.

Format: `profile -v`

### Editing a profile: `profile -e`

Edits an existing profile in NUScheduler.

Format: `profile -e INDEX [n/NAME] [p/PHONE] [e/EMAIL] [tg/TELEGRAM_USERNAME] [t/TAG]…`

* Edits the profile at the specified `INDEX`. The index refers to the index number shown in the displayed profile list. The index **must be a positive integer** 1, 2, 3, ...
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* You can remove the profile's telegram username by typing `tg/` without specifying any username after it.
* When editing tags, the existing tags of the profile will be removed i.e adding of tags is not cumulative.
* You can remove all the profile’s tags by typing `t/` without specifying any tags after it.

Examples:
* `profile -e 1 p/91234567 e/johndoe@u.nus.edu` Edits the phone number and email address of the 1st profile to be `91234567` and `johndoe@u.nus.edu` respectively.
* `profile -e 2 n/Betsy Crower t/` Edits the name of the 2nd profile to be `Betsy Crower` and clears all existing tags.
* `profile -e 3 tg/ t/` Clears the telegram username and tags of the 3rd profile.

### Finding profiles by name: `profile -f KEYWORD [MORE_KEYWORDS]`

Find profiles whose names contain any of the given keywords.

* The search is case-insensitive. e.g `hans` will match `Hans`
* The order of the keywords does not matter. e.g. `Hans Bo` will match `Bo Hans`
* Only the name is searched.
* Partial match will also be returned. e.g. `han` will match `hans`
* Profiles matching at least one keyword will be returned (i.e. `OR` search).
  e.g. `Hans Bo` will return `Hans Gruber`, `Bo Yang`

Examples:
* `profile -f Jane` returns `jane` and `Jane Doe`
* `profile -f alex david john` returns `Alex Yeoh`, `David Li`, `Johnny Smith`<br>
  ![result for 'profile -f alex david john'](images/findAlexDavidJohnResult.png)


### Deleting a profile: `profile -d`

Deletes a specified profile from NUScheduler.

Format: `profile -d INDEX`

* Deletes the profile at the specified `INDEX`.
* The index refers to the index number shown in the displayed profile list.
* The index **must be a positive integer** 1, 2, 3, …​

Example:
* `profile -d 1` deletes the first profile listed.

### Adding an event: `event -a`

Adds an event with a name, a start timing and end timing.

Format: `event -a n/TITLE s/START e/END [t/TAG]… [p/PROFILE]…`

* The start and end dates can be specified in [various formats](#accepted-date-time-formats).
* The start date must occur before or on the same day and time as the end date.

<div markdown="span" class="alert alert-primary">:bulb: **Tip:**
An event can have 0 or more profiles. An event can have 0 or more tags.
</div>

### Viewing upcoming events: `event -u`

Displays a list of upcoming events, ordered by the date, for the next specified number of days.

Format: `event -u DAYS`

* The days refer to the number of days after the current date. All events within this time frame will be displayed. Events
oncurring on the day the command is entered will not be displayed.
* The days **must be a positive integer** 1, 2, 3, ...

Example:
* `event -u 5` when used on `22-10-2022` displays all events taking place in the next 5 days from `23-10-22` to `27-10-22` with both dates included.

### Viewing all events: `event -v`

Shows a list of all events in the NUScheduler.

Format: `event -v`

### Editing a event: `event -e`

Edits an existing event in NUScheduler.

Format: `event -e INDEX [n/TITLE] [s/START] [e/END] [t/TAG]… [p/PROFILE]…`

* Edits the event at the specified `INDEX`. The index refers to the index number shown in the displayed event list. The index **must be a positive integer** 1, 2, 3, ...
* At least one of the optional fields must be provided.
* Existing values will be updated to the input values.
* When editing tags, the existing tags of the event will be removed i.e adding of tags is not cumulative.
* You can remove all the event’s tags by typing `t/` without specifying any tags after it.
* The start and end dates can be specified in [various formats](#accepted-date-time-formats).

### Finding events by date or title: `event -f KEYWORD_OR_DATE [MORE]`

Find events whose title contain any of the given keywords or start times contain any of the given start times.

* Date search will occur when all inputs are [valid dates](#accepted-date-time-formats), otherwise, keyword search will occur.
* The date search occurs only by date, ignoring the time, e.g. `11/10/2022 08:00` will match any events that start on `11/10/2022`.
* The keyword search is case-insensitive. e.g `birthday` will match `Birthday`.
* The order of the keywords does not matter. e.g. `one two` will match `two one`.
* Partial match will also be returned. e.g. `inter` will match `interview`
* Events matching at least one keyword will be returned (i.e. `OR` search) e.g. `interview meeting` will return `Meeting Tom`, `Job Interview`.

### Deleting an event: `event -d`

Deletes a specified event from NUScheduler.

Format: `event -d INDEX`

* Deletes the events at the specified `INDEX`.
* The index refers to the index number shown in the displayed event list.
* The index **must be a positive integer** 1, 2, 3, ...

Example:
* `event -v` followed by `event -d 2` deletes the 2nd event displayed.

### Clearing all profiles and events: `clear`

Clears all profiles and events from the NUScheduler.

Format: `clear`

### Exiting the program: `exit`

Exits the program.

Format: `exit`

### Advanced Features

#### Session-Based Command History

Access the previous commands you've made within each session.

* Use the up arrow key, <kbd>&#8593;</kbd> to navigate to the previous command.
* Use the down arrow key, <kbd>&#8595;</kbd> to navigate to the next command.

<div markdown="block" class="alert alert-info">

:information_source: **Notes about the command history**:

* Only successful commands are tracked, commands that results in an error are not stored.
* Every time NUScheduler is closed, the command history is reset.
* Edits made on the command history are not tracked.

</div>

#### Tag Aliases

Use aliases to quickly enter tags.

Example: 

* `events -e 1 t/tut` Edits the tag of the 1st event shown to `tutorial`.  

| Alias | Result       | 
|-------|--------------|
| assm  | assignment   |
| lec   | lecture      |
| pres  | presentation |
| rec   | recitation   |
| ta    | tutor        |
| tut   | tutorial     |


#### Quick Links

Get easy access to some of your favourite NUS websites, right from the menu.

1. Click on `Links` in the menu bar. A dropdown should appear.
2. Click on the link you want to visit, if you want to visit `Canvas`, click on `Canvas`.
3. The website should open in your browser.

<div markdown="block" class="alert alert-primary">

:bulb: **Tips:**

* Press <kbd> F2 </kbd> to open LumiNUS.
* Press <kbd> F3 </kbd> to open Canvas.
* Press <kbd> F4 </kbd> to open EduRec.

</div>


--------------------------------------------------------------------------------------------------------------------

## FAQ

### Accepted Date Time Formats

NUScheduler accepts date-time formats both with and without a time specified. For example, date-only formats can be used to specify all day events.

#### Date-only formats

- dd/MM/yyyy
- dd-MM-yyyy
- dd MM yyyy
- dd/MM/yy
- dd-MM-yy
- dd MM yy
- dd/MM (uses current year by default)
- dd-MM (uses current year by default)
- dd MM (uses current year by default)

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the date format:**<br>

* Days can be specified with either one or two digits. e.g. `5` and `05` both refer to the same day.
* Months can be specified with either digits or letters. e.g. `3`, `03`, `mar` and `march` all refer to the same month.
* Years must be specified with four digits. e.g. `2022`

</div>

#### Date time formats

The following time formats can be appended after a whitespace to the end of any of the above date formats.

- HH:mm
- HHmm
- HH:mm:ss
- HHmmss

Example:
* `25/05/2015 10:00`

<div markdown="block" class="alert alert-info">

**:information_source: Notes about the date format:**<br>

* Hours, minutes and seconds must be specified using two digits.
* `dd MM HHmm` is not supported, and will be recognised as `dd MM yyyy`.

</div>

--------------------------------------------------------------------------------------------------------------------

## Command summary

| Action                     | Format, Examples                                                                |
|----------------------------|---------------------------------------------------------------------------------|
| **Add Profile**            | `profile -a n/NAME p/PHONE_NUMBER e/EMAIL [tg/TELEGRAM_USERNAME] [t/TAG]…`      |
| **Delete Profile**         | `profile -d INDEX`                                                              |
| **Edit Profile**           | `profile -e INDEX [n/NAME] [p/PHONE] [e/EMAIL] [tg/TELEGRAM_USERNAME] [t/TAG]…` |
| **View Profiles**          | `profile -v`                                                                    |
| **Find Profile**           | `profile -f KEYWORD [MORE_KEYWORDS]`                                            |
| **Add Event**              | `event -a n/TITLE s/START e/END [t/TAG]… [p/PROFILE]…`                          |
| **Delete Event**           | `event -d INDEX`                                                                |
| **Edit Event**             | `event -e INDEX [n/TITLE] [s/START] [e/END] [t/TAG]… [p/PROFILE]…`              |
| **View Events**            | `event -v`                                                                      |
| **View Upcoming Event(s)** | `event -u DAYS`                                                                 |
| **Find Event**             | `event -f KEYWORD_OR_DATE [MORE]`                                               |
