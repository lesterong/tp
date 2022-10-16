package seedu.address.model.event;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class DateTimeTest {

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new DateTime(null));
    }

    @Test
    public void constructor_invalidDate_throwsIllegalArgumentException() {
        String invalidDate = "";
        assertThrows(IllegalArgumentException.class, () -> new DateTime(invalidDate));
    }

    @Test
    public void isValidDateTime() {
        // null date
        assertThrows(NullPointerException.class, () -> DateTime.isValidDateTime(null));

        // blank date
        assertFalse(DateTime.isValidDateTime(""));
        assertFalse(DateTime.isValidDateTime(" "));

        // missing time
        assertTrue(DateTime.isValidDateTime("24/02/2022")); // missing local part
        assertTrue(DateTime.isValidDateTime("31 Jan 2015")); // missing '@' symbol
        assertTrue(DateTime.isValidDateTime("25-05-2018"));

        // invalid date
        assertFalse(DateTime.isValidDateTime("40/02/2022")); // missing local part
        assertFalse(DateTime.isValidDateTime("21 Rep 2015")); // missing '@' symbol
        assertFalse(DateTime.isValidDateTime("25-05-lala"));

        // invalid time
        assertFalse(DateTime.isValidDateTime("24/02/2022 26:24")); // missing local part
        assertFalse(DateTime.isValidDateTime("31 Jan 2015 13:66")); // missing '@' symbol
        assertFalse(DateTime.isValidDateTime("25-05-2018 aabb"));

        // valid date and time
        assertTrue(DateTime.isValidDateTime("24/02/2022 13:43")); // missing local part
        assertTrue(DateTime.isValidDateTime("31 Jan 2015 16:21")); // missing '@' symbol
        assertTrue(DateTime.isValidDateTime("25-05-2018 04:55"));

    }

}
