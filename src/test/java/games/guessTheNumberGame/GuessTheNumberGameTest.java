package games.guessTheNumberGame;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GuessTheNumberGameTest {

    @Test
    void playStartsGameEngine() {
        // Arrange
        GuessTheNumberGame guessTheNumberGame = new GuessTheNumberGame();

        // Act
        guessTheNumberGame.play();

        // Assert
        assertTrue(TestGameEngine.isStartCalled());
    }

    // Test GameEngine implementation for testing purposes
    private static class TestGameEngine extends GameEngine {
        private static boolean startCalled = false;

        @Override
        public void start() {
            startCalled = true;
        }

        public static boolean isStartCalled() {
            return startCalled;
        }
    }
}