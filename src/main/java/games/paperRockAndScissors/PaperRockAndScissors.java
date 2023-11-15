package games.paperRockAndScissors;

import games.Minigame;

public class PaperRockAndScissors implements Minigame {

    public void play() {
        Game game = new Game(new UserInterface(), new GameLogic());
        game.start();
    }
}