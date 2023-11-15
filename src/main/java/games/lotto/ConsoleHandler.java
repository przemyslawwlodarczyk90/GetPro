package games.lotto;

import lombok.experimental.UtilityClass;

import java.io.PrintStream;

@UtilityClass
public class ConsoleHandler {

    private final PrintStream out = System.out;

    public void printMessage(String message) {
        out.println(message);
    }
}