package games.lotto;

import lombok.experimental.UtilityClass;

import java.util.Random;

@UtilityClass
public class RandomNumberGenerator {
    private static Random random = new Random();

    public void setRandomInstance(Random newRandom) {
        random = newRandom;
    }

    public int[] generateRandomNumbers() {
        int[] numbers = new int[6];

        for (int i = 0; i < 6; i++) {
            numbers[i] = random.nextInt(99) + 1;
        }

        return numbers;
    }
}