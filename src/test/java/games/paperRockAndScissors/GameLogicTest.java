package games.paperRockAndScissors;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameLogicTest {

    @Test
    void testDetermineWinner_PlayerWins() {
        GameLogic gameLogic = new GameLogic();


        assertEquals(1, gameLogic.determineWinner(1, 3));
        assertEquals(1, gameLogic.determineWinner(2, 1));
        assertEquals(1, gameLogic.determineWinner(3, 2));
    }

    @Test
    void testDetermineWinner_ComputerWins() {
        GameLogic gameLogic = new GameLogic();


        assertEquals(-1, gameLogic.determineWinner(1, 2));
        assertEquals(-1, gameLogic.determineWinner(2, 3));
        assertEquals(-1, gameLogic.determineWinner(3, 1));
    }

    @Test
    void testDetermineWinner_Draw() {
        GameLogic gameLogic = new GameLogic();


        assertEquals(0, gameLogic.determineWinner(1, 1));
        assertEquals(0, gameLogic.determineWinner(2, 2));
        assertEquals(0, gameLogic.determineWinner(3, 3));
    }
}