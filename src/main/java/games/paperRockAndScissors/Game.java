package games.paperRockAndScissors;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Game {

        private final UserInterface userInterface;
        private final GameLogic gameLogic;

        public void start() {
            userInterface.displayWelcomeMessage();
            int rounds = userInterface.getNumberOfRounds();

            gameLogic.playGame(rounds, userInterface);
        }
    }

