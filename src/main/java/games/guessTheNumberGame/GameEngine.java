package games.guessTheNumberGame;

import lombok.AllArgsConstructor;
import java.util.Scanner;

@AllArgsConstructor

public class GameEngine {
    private final Scanner scanner;
    private final GameManager gameManager;

    public GameEngine() {
        this(new Scanner(System.in), new GameManager());
    }

    public void start() {
        gameManager.initializeGame();

        while (true) {
            System.out.print("\nPodaj swoją liczbę: ");
            int userGuess = getUserGuess();
            gameManager.processUserGuess(userGuess);

            if (gameManager.isGameOver()) {
                gameManager.endGame();
                break;
            }

            gameManager.adjustPoints();
            gameManager.displayRemainingAttemptsAndPoints();
        }
    }

    private int getUserGuess() {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Błędny format. Proszę podać liczbę.");
            scanner.nextLine();
            return getUserGuess();
        }
    }
}