package games.guessTheNumberGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;  // Add this import

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameEngineTest {

    private GameEngine gameEngine;
    private TestGameManager testGameManager;

    @BeforeEach
    void setUp() {
        testGameManager = new TestGameManager();
        gameEngine = new GameEngine(new Scanner(System.in), testGameManager);  // Fix the constructor invocation
    }

    @Test
    void startGameEndsAfterCorrectGuess() {
        // Simulate user input
        provideUserInput("42");

        gameEngine.start();

        // Verify game state after the game ends
        assertTrue(testGameManager.isGameOver());
        assertEquals(1, testGameManager.getProcessUserGuessCount());
        assertEquals(1, testGameManager.getAdjustPointsCount());
        assertEquals(1, testGameManager.getDisplayRemainingAttemptsAndPointsCount());
    }

    @Test
    void startGameEndsAfterMaxAttempts() {
        // Simulate user input
        provideUserInput("1", "2", "3", "4", "5");

        gameEngine.start();

        // Verify game state after the game ends
        assertTrue(testGameManager.isGameOver());
        assertEquals(5, testGameManager.getProcessUserGuessCount());
        assertEquals(4, testGameManager.getAdjustPointsCount());
        assertEquals(5, testGameManager.getDisplayRemainingAttemptsAndPointsCount());
    }

    @Test
    void startGameHandlesInvalidInputOnceThenContinues() {
        // Simulate user input
        provideUserInput("invalid", "42");

        gameEngine.start();

        // Verify game state after the game ends
        assertTrue(testGameManager.isGameOver());
        assertEquals(1, testGameManager.getProcessUserGuessCount());
        assertEquals(1, testGameManager.getAdjustPointsCount());
        assertEquals(1, testGameManager.getDisplayRemainingAttemptsAndPointsCount());
    }

    // Helper method to provide user input for testing
    private void provideUserInput(String... inputs) {
        String input = String.join(System.lineSeparator(), inputs);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }



    public class TestGameManager extends GameManager {
        private int processUserGuessCount = 0;
        private int adjustPointsCount = 0;
        private int displayRemainingAttemptsAndPointsCount = 0;
        private boolean gameEnded = false;

        @Override
        public void processUserGuess(int userGuess) {
            super.processUserGuess(userGuess);
            processUserGuessCount++;
        }

        @Override
        public void adjustPoints() {
            super.adjustPoints();
            adjustPointsCount++;
        }

        @Override
        public void displayRemainingAttemptsAndPoints() {
            super.displayRemainingAttemptsAndPoints();
            displayRemainingAttemptsAndPointsCount++;
        }

        @Override
        public boolean isGameOver() {
            return gameEnded;
        }

        // Helper method to set the gameEnded flag
        public void setGameEnded(boolean gameEnded) {
            this.gameEnded = gameEnded;
        }

        int getProcessUserGuessCount() {
            return processUserGuessCount;
        }

        int getAdjustPointsCount() {
            return adjustPointsCount;
        }

        int getDisplayRemainingAttemptsAndPointsCount() {
            return displayRemainingAttemptsAndPointsCount;
        }
    }}