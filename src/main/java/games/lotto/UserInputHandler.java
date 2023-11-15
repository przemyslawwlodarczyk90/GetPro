package games.lotto;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputHandler {

    private static final int DEFAULT_MIN_VALUE = 1;
    private static final int DEFAULT_MAX_VALUE = 99;

    public static int[] getUserInput() {
        int[] userNumbers = new int[6];
        Scanner scanner = new Scanner(System.in);

        try {
            int i = 0;
            while (i < 6) {
                System.out.println("Podaj liczbę " + (i + 1) + ":");
                if (!scanner.hasNextInt()) {
                    System.out.println("Nie podano wystarczającej liczby liczb. Podaj liczbę ponownie:");
                    scanner.nextLine();
                    continue;
                }

                int number = scanner.nextInt();

                if (number < DEFAULT_MIN_VALUE || number > DEFAULT_MAX_VALUE) {
                    System.out.println("Podano liczbę spoza zakresu. Podaj liczbę ponownie:");
                    continue;
                }

                userNumbers[i] = number;
                i++;
            }
        } catch (InputMismatchException e) {
            System.out.println("Podano niepoprawny format danych. Podaj liczbę ponownie:");
            scanner.nextLine();
        }

        return userNumbers;
    }
}