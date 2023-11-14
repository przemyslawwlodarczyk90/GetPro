// GameManager.java
package games.guessTheNumberGame;

import lombok.Getter;

@Getter
public class GameManager {
    static final int MAX_ATTEMPTS = 10;

    public final int secretNumber;
    protected int attempts;
    public int points;

      public GameManager() {
        this.secretNumber = generateSecretNumber();
        this.attempts = 0;
        this.points = 100;
    }

     int generateSecretNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    public void initializeGame() {
        System.out.println("Witaj w grze Zgadnij Liczbę!");
        System.out.println();
        System.out.println("Wylosowałem liczbę z zakresu od 1 do 100 (włącznie), a Ty ją musisz odgadnąć :)");
    }

    public void processUserGuess(int userGuess) {
        attempts++;
        if (userGuess < 1 || userGuess > 100) {
            System.out.println("Proszę podać liczbę z zakresu od 1 do 100.");
            return;
        }

        if (userGuess == secretNumber) {
            System.out.println("\nGratulacje! Zgadłeś liczbę w " + attempts + " próbach.");
            System.out.println("Liczba zdobytych punktów: " + points);
            System.exit(0);
        } else if (userGuess < secretNumber) {
            System.out.println("Za nisko. Spróbuj ponownie!");
        } else {
            System.out.println("Za wysoko. Spróbuj ponownie!");
        }
    }

    boolean isGameOver() { // Change access modifier to package-private
        return attempts >= MAX_ATTEMPTS;
    }

    public void endGame() {
        System.out.println("\nPrzykro mi, skończyły Ci się próby. Wylosowana liczba to: " + secretNumber);
        System.exit(0);
    }

    public void adjustPoints() {
        points -= 10;
    }

    public void displayRemainingAttemptsAndPoints() {
        System.out.println("Pozostałe próby: " + (MAX_ATTEMPTS - attempts));
        System.out.println("Twoje aktualne punkty: " + points);
    }
}