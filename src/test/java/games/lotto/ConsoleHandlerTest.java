import games.lotto.ConsoleHandler;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ConsoleHandlerTest {

    @Test
    void testPrintMessage() {
        // Redirect System.out to capture printed messages
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        // Call the method to be tested
        ConsoleHandler.printMessage("Test Message");

        // Get the printed message
        String printedMessage = outputStreamCaptor.toString().trim();

        // Assert the printed message
        try {
            assertEquals("Test Message", printedMessage);
        } catch (AssertionError e) {
            // Provide more information about the failure
            fail("Expected: 'Test Message' but was: '" + printedMessage + "'");
        }

        // Reset System.out
        System.setOut(System.out);
    }

    // Add more test cases as needed
}