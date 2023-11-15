package games;

import games.guessTheNumberGame.GuessTheNumberGame;
import games.lotto.Lotto;
import games.paperRockAndScissors.PaperRockAndScissors;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameMenu {
    private final Scanner scanner;

    public GameMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println();
        System.out.println("************** Witaj w świecie gier! :) ****************** ");
        System.out.println();
        System.out.println("Wybierz grę:");
        System.out.println("1. Zgadywanie Liczb");
        System.out.println("2. Lotto");
        System.out.println("3. Papier, Kamień, Nożyce");
        System.out.println("0. Wyjście");

        int choice = getUserChoice();

        switch (choice) {
            case 1:
                playGame(new GuessTheNumberGame());
                break;
            case 2:
                playGame(new Lotto());
                break;
            case 3:
                playGame(new PaperRockAndScissors());
                break;
            case 0:
                System.out.println("Dziękujemy za grę. Do zobaczenia!");
                break;
            default:
                System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                displayMenu();
        }
    }

    private int getUserChoice() {
        try {
            System.out.print("Twój wybór: ");
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Wprowadź poprawną liczbę!");
            scanner.nextLine();
            return getUserChoice();
        }
    }

    private void playGame(Minigame minigame) {
        minigame.play();
    }

    public void closeScanner() {
        scanner.close();
    }
}