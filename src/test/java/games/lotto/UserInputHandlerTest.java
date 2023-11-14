package games.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        assertThrows(NoSuchElementException.class, () -> {
            UserInputHandler.getUserInput();
        });
    }

    private void provideTestInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}