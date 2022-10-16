package seedu.address.logic.parser.event;

import static seedu.address.commons.core.Messages.MESSAGE_FLAG_NOT_SPECIFIED;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.logic.commands.event.EventCommand;
import seedu.address.logic.parser.Parser;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new EventCommand object
 */
public class EventCommandParser implements Parser<EventCommand> {
    private static final Pattern EVENT_COMMAND_FORMAT = Pattern.compile(
            "\\s+(-(?<eventOption>\\S*))(\\s+(?!-)\\S+)*");
    /**
     * Parses the given {@code String} of arguments in the context of the EventCommand
     * and returns an EventCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EventCommand parse(String args) throws ParseException {

        if (!args.matches("\\s+-.*")) {
            Matcher matcher = Pattern.compile("(\\s+-\\S*)").matcher(args);
            long numFlags = matcher.results().count();
            if (numFlags == 0) {
                throw new ParseException(String.format(
                        MESSAGE_FLAG_NOT_SPECIFIED, EventCommand.EVENT_FORMAT + EventCommand.VALID_FLAGS));
            } else if (numFlags == 1) {
                throw new ParseException(EventCommand.OPTION_WRONG_ORDER);
            } else {
                throw new ParseException(EventCommand.OPTION_WRONG_ORDER_NO_MULTIPLE);
            }
        }

        final Matcher eventCommandMatcher = EVENT_COMMAND_FORMAT.matcher(args);

        if (!eventCommandMatcher.matches()) {
            throw new ParseException(EventCommand.OPTION_NO_MULTIPLE);
        }

        String eventOption = eventCommandMatcher.group("eventOption");

        switch (eventOption) {
        default:
            throw new ParseException(EventCommand.OPTION_UNKNOWN);
        }
    }
}
