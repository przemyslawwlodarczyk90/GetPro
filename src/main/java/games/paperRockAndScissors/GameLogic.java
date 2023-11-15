package games.paperRockAndScissors;

import java.util.Random;
import java.util.Scanner;

public class GameLogic {
    private int playerScore;
    private int computerScore;

    public GameLogic() {
        this.playerScore = 0;
        this.computerScore = 0;
    }

    public void playGame(int rounds, UserInterface userInterface) {
        Scanner scanner = userInterface.getScanner();
        Random random = new Random();

        for (int round = 1; round <= rounds; round++) {
            userInterface.displayRoundStartMessage(round);

            int playerChoice = userInterface.getPlayerChoice(scanner);
            int computerChoice = random.nextInt(3) + 1;

            userInterface.displayComputerChoice(computerChoice);

            int result = determineWinner(playerChoice, computerChoice);

            updateScores(result, userInterface);
        }

        userInterface.displayFinalResults(playerScore, computerScore);
    }

    private void updateScores(int result, UserInterface userInterface) {
        if (result == 1) {
            userInterface.displayPlayerWinsRound();
            playerScore++;
        } else if (result == -1) {
            userInterface.displayComputerWinsRound();
            computerScore++;
        } else {
            userInterface.displayRoundDraw();
        }
    }

    int determineWinner(int playerChoice, int computerChoice) {
        if (playerChoice == computerChoice) {
            return 0;
        } else if ((playerChoice == 1 && computerChoice == 3) ||
                (playerChoice == 2 && computerChoice == 1) ||
                (playerChoice == 3 && computerChoice == 2)) {
            return 1;
        } else {
            return -1;
        }
    }
}