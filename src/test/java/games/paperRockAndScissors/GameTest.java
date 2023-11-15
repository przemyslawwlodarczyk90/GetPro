package games.paperRockAndScissors;

import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {

    @Test
    void testStart() {

        UserInterface userInterface = new TestUserInterface();
        GameLogic gameLogic = new TestGameLogic();


        Game game = new Game(userInterface, gameLogic);


        game.start();

        assertTrue(((TestUserInterface) userInterface).isWelcomeMessageDisplayed());
        assertTrue(((TestUserInterface) userInterface).isNumberOfRoundsRequested());
        assertTrue(((TestGameLogic) gameLogic).isGamePlayed());
    }



    private static class TestUserInterface extends UserInterface {
        private boolean welcomeMessageDisplayed;
        private boolean numberOfRoundsRequested;

        @Override
        public void displayWelcomeMessage() {
            welcomeMessageDisplayed = true;
        }

        @Override
        public int getNumberOfRounds() {
            numberOfRoundsRequested = true;
            return 0;
        }

        public boolean isWelcomeMessageDisplayed() {
            return welcomeMessageDisplayed;
        }

        public boolean isNumberOfRoundsRequested() {
            return numberOfRoundsRequested;
        }
    }

    private static class TestGameLogic extends GameLogic {
        private boolean gamePlayed;

        @Override
        public void playGame(int rounds, UserInterface userInterface) {
            gamePlayed = true;
        }

        public boolean isGamePlayed() {
            return gamePlayed;
        }
    }
}