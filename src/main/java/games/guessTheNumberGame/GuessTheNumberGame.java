package games.guessTheNumberGame;

import games.Minigame;

public class GuessTheNumberGame implements Minigame {

    @Override
    public void play() {
        GameEngine gameEngine = new GameEngine();
        gameEngine.start();
    }
}