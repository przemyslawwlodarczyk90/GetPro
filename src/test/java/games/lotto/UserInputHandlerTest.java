package games.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class UserInputHandlerTest {

    @BeforeEach
    void resetTestInput() {
        System.setIn(System.in);
    }

    @Test
    void testUserInputInRange() {
        provideTestInput("1\n2\n3\n4\n5\n6\n");

        int[] result = UserInputHandler.getUserInput();

        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, result);
    }

    @Test
    void testUserInputWithInvalidFormat() {
        provideTestInput("1\n2\n3\nabc\n5\n6\n");

        int[] result = UserInputHandler.getUserInput();

        int[] expected = {1, 2, 3, 0, 5, 6};  // Oczekujemy 0 dla niepoprawnego formatu
        assertArrayEquals(expected, result);
    }

    @Test
    void testUserInputWithInvalidRange() {
        provideTestInput("1\n2\n3\n100\n5\n6\n");

        int[] result = UserInputHandler.getUserInput();

        int[] expected = {1, 2, 3, 0, 5, 6};  // Oczekujemy 0 dla liczby spoza zakresu
        assertArrayEquals(expected, result);
    }

    private void provideTestInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }
}