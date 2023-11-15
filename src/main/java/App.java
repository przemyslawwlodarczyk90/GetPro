import games.GameMenu;
import games.Minigame;
import games.guessTheNumberGame.GuessTheNumberGame;
import games.lotto.Lotto;
import games.paperRockAndScissors.PaperRockAndScissors;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameMenu gameMenu = new GameMenu(scanner);

        boolean exit = false;

        while (!exit) {
            gameMenu.displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

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
                    exit = true;
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Wybierz ponownie.");
                    break;
            }
        }

        gameMenu.closeScanner();
    }

    private static void playGame(Minigame game) {
        game.play();
    }
}