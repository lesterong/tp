package seedu.address.logic.commands.event;

import seedu.address.logic.commands.Command;

/**
 * Represents a Event command with hidden internal logic and the ability to be executed.
 */
public abstract class EventCommand extends Command {

    public static final String COMMAND_WORD = "event";

    public static final String EVENT_FORMAT = "Format: " + COMMAND_WORD + " -option\n";

    public static final String VALID_FLAGS = "Please use one of the following valid flags: "
            + "None implemented";
    public static final String OPTION_UNKNOWN = "That is not a valid option flag.\n";

    public static final String OPTION_NO_MULTIPLE = "Multiple option flags are not allowed.\n" + EVENT_FORMAT;

    public static final String OPTION_WRONG_ORDER = "Option flag should be in front.\n" + EVENT_FORMAT;

    public static final String OPTION_WRONG_ORDER_NO_MULTIPLE =
            "Only one option flag should be specified in front.\n" + EVENT_FORMAT;

}
