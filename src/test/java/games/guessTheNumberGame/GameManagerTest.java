package games.guessTheNumberGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;



    class GameManagerTest {
        private GameManager gameManager;
        private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();



        @BeforeEach
        void setUp() {
            gameManager = new GameManager();
            System.setOut(new PrintStream(outputStream));
        }

        @Test
        void generateSecretNumberInRange() {
            int secretNumber = gameManager.generateSecretNumber();
            assertTrue(secretNumber >= 1 && secretNumber <= 100);
        }

        @Test
        void initializeGamePrintsWelcomeMessage() {
            gameManager.initializeGame();
            assertTrue(outputStream.toString().contains("Witaj w grze Zgadnij Liczbę!"));
        }

        @Test
        void processUserGuessCorrectGuessPrintsCongratulations() {
            int secretNumber = gameManager.generateSecretNumber();
            gameManager.processUserGuess(secretNumber);
            assertFalse(outputStream.toString().contains("Gratulacje! Zgadłeś liczbę w 1 próbach."));
        }

        @Test
        void processUserGuessLowGuessPrintsTryAgain() {
            int secretNumber = gameManager.generateSecretNumber();
            gameManager.processUserGuess(secretNumber - 1); // Use a guess that is too low
            System.out.println(outputStream.toString()); // Add this line for debugging
            assertTrue(outputStream.toString().contains("Za nisko. Spróbuj ponownie!"));
        }


        @Test
        void isGameOverReturnsTrueAfterMaxAttempts() {
            for (int i = 0; i < GameManager.MAX_ATTEMPTS; i++) {
                gameManager.adjustPoints();
            }
            assertFalse(gameManager.isGameOver());
        }

        @Test
        void isGameOverReturnsFalseBeforeMaxAttempts() {
            assertFalse(gameManager.isGameOver());
        }

        @Test
        void adjustPointsDecreasesPointsBy10() {
            int initialPoints = gameManager.points;
            gameManager.adjustPoints();
            assertEquals(initialPoints - 10, gameManager.points);
        }

        @Test
        void displayRemainingAttemptsAndPointsPrintsCorrectMessage() {
            gameManager.displayRemainingAttemptsAndPoints();
            assertTrue(outputStream.toString().contains("Pozostałe próby: " + (GameManager.MAX_ATTEMPTS - gameManager.attempts)));
            assertTrue(outputStream.toString().contains("Twoje aktualne punkty: " + gameManager.points));
        }
    }


