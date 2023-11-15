package games.lotto;


import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputHandlerTest {

    @Test
    void getUserInputWithValidNumbers() {
        String input = "1\n2\n3\n4\n5\n6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        int[] result = UserInputHandler.getUserInput();

        int[] expected = {1, 2, 3, 4, 5, 6};
        assertArrayEquals(expected, result);

        System.setIn(System.in);
    }

    @Test
    void getUserInputWithInvalidFormat() {
        String input = "1\nabc\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            UserInputHandler.getUserInput();
        });


        System.setIn(System.in);
    }


    @Test
    void getUserInputWithMixedValidAndInvalidInput() {
        String input = "1\nabc\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThrows(NoSuchElementException.class, () -> {
            UserInputHandler.getUserInput();
        });

        System.setIn(System.in);
    }
}