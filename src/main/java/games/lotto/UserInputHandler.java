package games.lotto;

import lombok.experimental.UtilityClass;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

@UtilityClass
public class UserInputHandler {

    private final int DEFAULT_MIN_VALUE = 1;
    private final int DEFAULT_MAX_VALUE = 99;
    private int minValue = DEFAULT_MIN_VALUE;
    private int maxValue = DEFAULT_MAX_VALUE;
    private InputStream inputStream = System.in; // Domyślnie korzystamy ze standardowego strumienia wejściowego

    public void setMinValue(int minValue) {
        UserInputHandler.minValue = minValue;
    }

    public void setMaxValue(int maxValue) {
        UserInputHandler.maxValue = maxValue;
    }

    public void setInputStream(InputStream inputStream) {
        UserInputHandler.inputStream = inputStream;
    }

    public int[] getUserInput() {
        Scanner scanner = new Scanner(inputStream);
        int[] userNumbers = new int[6];

        for (int i = 0; i < 6; i++) {
            try {
                int number = scanner.nextInt();

                if (number < minValue || number > maxValue) {
                    System.out.println("Podano liczbę spoza zakresu. Podaj liczbę ponownie:");
                    i--; // Ponowna próba wprowadzenia tej samej liczby
                    continue;
                }

                userNumbers[i] = number;
            } catch (InputMismatchException e) {
                System.out.println("Podano niepoprawny format danych. Podaj liczbę ponownie:");
                scanner.next(); // Wyczyść bufor wejściowy
                i--; // Ponowna próba wprowadzenia tej samej liczby
            }
        }

        return userNumbers;
    }
}