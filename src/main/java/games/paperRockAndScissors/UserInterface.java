package games.paperRockAndScissors;

import java.util.Scanner;

class UserInterface {
    private final Scanner scanner;

    public UserInterface() {
        this.scanner = new Scanner(System.in);
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void displayWelcomeMessage() {
        System.out.println("Witaj w grze Kamień, Papier, Nożyce!");
    }

    public int getNumberOfRounds() {
        int rounds;
        do {
            System.out.print("Podaj liczbę rund: ");
            while (!scanner.hasNextInt()) {
                System.out.println("To nie jest liczba!");
                scanner.next();
            }
            rounds = scanner.nextInt();
        } while (rounds <= 0);
        return rounds;
    }

    public void displayRoundStartMessage(int round) {
        System.out.println("\nRunda " + round);
    }

    public int getPlayerChoice(Scanner scanner) {
        System.out.print("Wybierz (1 - Kamień, 2 - Papier, 3 - Nożyce): ");

        while (!scanner.hasNextInt()) {
            System.out.println("To nie jest liczba!");
            scanner.next();
        }

        int playerChoice = scanner.nextInt();

        if (playerChoice < 1 || playerChoice > 3) {
            System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
            return getPlayerChoice(scanner);
        }

        return playerChoice;
    }

    public void displayComputerChoice(int computerChoice) {
        System.out.println("Komputer wybrał: " + getChoiceName(computerChoice));
    }

    public void displayPlayerWinsRound() {
        System.out.println("Ty wygrywasz rundę!");
    }

    public void displayComputerWinsRound() {
        System.out.println("Komputer wygrywa rundę.");
    }

    public void displayRoundDraw() {
        System.out.println("Runda zakończona remisem.");
    }

    public void displayFinalResults(int playerScore, int computerScore) {
        System.out.println("\nWyniki końcowe:");
        System.out.println("Twój wynik: " + playerScore);
        System.out.println("Wynik komputera: " + computerScore);

        if (playerScore > computerScore) {
            System.out.println("Gratulacje, wygrałeś grę!");
        } else if (playerScore < computerScore) {
            System.out.println("Komputer wygrał grę. Spróbuj ponownie!");
        } else {
            System.out.println("Gra zakończona remisem. Możesz spróbować ponownie.");
        }
    }

    public String getChoiceNameString(int choice) {
        return getChoiceName(choice);
    }

    private String getChoiceName(int choice) {
        switch (choice) {
            case 1:
                return "Kamień";
            case 2:
                return "Papier";
            case 3:
                return "Nożyce";
            default:
                return "Nieznany wybór";
        }
    }
}