package games.lotto;

import games.lotto.ConsoleHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ConsoleHandlerTest {
    private final PrintStream originalOut = System.out;
    private final InputStream originalIn = System.in;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    void testPrintMessage() {
        ConsoleHandler.printMessage("Test Message");
        assertEquals("Test Message\n", outContent.toString());
    }

    @Test
    void testGetIntInputWithValidInput() {
        String input = "42\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = ConsoleHandler.getIntInput();
        assertEquals(42, result);
    }

    @Test
    void testGetIntInputWithInvalidInput() {
        String input = "invalid\n42\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = ConsoleHandler.getIntInput();

        // Verify that the error message is printed
        assertEquals("Podano niepoprawny format danych.", outContent.toString().trim());

        // Verify that the correct value is eventually returned
        assertEquals(42, result);
    }

    @Test
    void testGetIntInputWithException() {
        String input = "not_an_int\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // Verify that an InputMismatchException is thrown
        assertThrows(InputMismatchException.class, ConsoleHandler::getIntInput);

        // Verify that the error message is printed
        assertEquals("Podano niepoprawny format danych.", outContent.toString().trim());
    }
}