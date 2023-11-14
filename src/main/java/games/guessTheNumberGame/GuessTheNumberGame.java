package games.guessTheNumberGame;

import games.Minigame;

public class GuessTheNumberGame implements Minigame {
    public static final int MAX_ATTEMPTS = 10;



    @Override
    public void play() {
        GameEngine gameEngine = new GameEngine();
        gameEngine.start();
    }
}