package games.paperRockAndScissors;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UserInterfaceTest {

    @Test
    void testGetNumberOfRounds() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInterface userInterface = new UserInterface();
        assertEquals(3, userInterface.getNumberOfRounds());
    }

    @Test
    void testGetPlayerChoice_ValidInput() {
        String input = "2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInterface userInterface = new UserInterface();
        Scanner scanner = userInterface.getScanner();
        assertEquals(2, userInterface.getPlayerChoice(scanner));
    }

    @Test
    void testGetPlayerChoice_InvalidInputThenValidInput() {
        String input = "invalid\n2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        UserInterface userInterface = new UserInterface();
        Scanner scanner = userInterface.getScanner();
        assertEquals(2, userInterface.getPlayerChoice(scanner));
    }

    @Test
    void testGetChoiceName() {
        UserInterface userInterface = new UserInterface();
        assertEquals("Kamień", userInterface.getChoiceNameString(1));
        assertEquals("Papier", userInterface.getChoiceNameString(2));
        assertEquals("Nożyce", userInterface.getChoiceNameString(3));
        assertEquals("Nieznany wybór", userInterface.getChoiceNameString(4));
    }


}