import games.lotto.Lotto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {
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
    void testLottoWin() {
        // Set the input stream with the desired user input
        String input = "1\n2\n3\n4\n5\n6\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Lotto lotto = new Lotto();
        lotto.play();

        // Adjust this part based on your actual implementation.
        String consoleOutput = outContent.toString().trim(); // Trim to remove leading/trailing whitespaces
        assertTrue(consoleOutput.contains("Gratulacje! Wygrałeś!"));
    }

    @Test
    void testLottoLose() {
        // Set the input stream with the desired user input
        String input = "1\n2\n3\n7\n8\n9\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Lotto lotto = new Lotto();
        lotto.play();

        // Adjust this part based on your actual implementation.
        String consoleOutput = outContent.toString().trim(); // Trim to remove leading/trailing whitespaces
        assertTrue(consoleOutput.contains("Niestety, tym razem nie udało się. Spróbuj ponownie!"));
    }
}