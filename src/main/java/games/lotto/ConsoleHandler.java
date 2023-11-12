package games.lotto;

import lombok.experimental.UtilityClass;

import java.util.InputMismatchException;
import java.util.Scanner;

@UtilityClass
public class ConsoleHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int getIntInput() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            printMessage("Podano niepoprawny format danych.");
            scanner.next(); // Wyczyść bufor wejściowy
            return getIntInput(); // Ponowne wywołanie metody dla ponownego wprowadzenia liczby
        }
    }
}