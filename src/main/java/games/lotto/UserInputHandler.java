package games.lotto;

import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

@UtilityClass
public class UserInputHandler {

    public final int DEFAULT_MIN_VALUE = 1;
    public final int DEFAULT_MAX_VALUE = 99;
    private int minValue = DEFAULT_MIN_VALUE;
    private int maxValue = DEFAULT_MAX_VALUE;
    private InputStream inputStream = System.in;

    public void setMinValue(int minValue) {
        UserInputHandler.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        UserInputHandler.maxValue = maxValue;
    }

    public void setInputStream(InputStream inputStream) {
        UserInputHandler.inputStream = inputStream;
    }

    public static int getMinValue() {
        return minValue;
    }

    public static int getMaxValue() {
        return maxValue;
    }

    public int[] getUserInput() {
        Scanner scanner = new Scanner(inputStream);
        int[] userNumbers = new int[6];

        for (int i = 0; i < 6; i++) {
            try {
                if (!scanner.hasNextInt()) {
                    System.out.println("Nie podano wystarczającej liczby liczb. Podaj liczbę ponownie:");
                    i--; // Retry for the same position
                    scanner.next(); // Consume invalid input
                    continue;
                }

                int number = scanner.nextInt();

                if (number < minValue || number > maxValue) {
                    System.out.println("Podano liczbę spoza zakresu. Podaj liczbę ponownie:");
                    i--; // Retry for the same position
                    continue;
                }

                userNumbers[i] = number;
            } catch (InputMismatchException e) {
                System.out.println("Podano niepoprawny format danych. Podaj liczbę ponownie:");
                i--; // Retry for the same position
                scanner.next(); // Consume invalid input
            }
        }

        return userNumbers;
    }
}