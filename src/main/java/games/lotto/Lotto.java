package games.lotto;

import games.Minigame;

import java.util.Arrays;
import java.util.Scanner;

public class Lotto implements Minigame {

    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void play() {
        System.out.println("Witaj w grze Lotek!");
        System.out.println("Podaj 6 liczb od 1 do 99:");

        int[] userNumbers = UserInputHandler.getUserInput();
        int[] generatedNumbers = RandomNumberGenerator.generateRandomNumbers();

        System.out.println("Twoje liczby: " + Arrays.toString(userNumbers));
        System.out.println("Wylosowane liczby: " + Arrays.toString(generatedNumbers));

        int correctNumbers = NumberComparator.countCorrectNumbers(userNumbers, generatedNumbers);

        if (correctNumbers == 6) {
            System.out.println("Gratulacje! Wygrałeś!");
        } else {
            System.out.println("Niestety, tym razem nie udało się. Spróbuj ponownie!");
        }


    }
}