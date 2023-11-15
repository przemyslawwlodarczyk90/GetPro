package games.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @BeforeEach
    void setUp() {

        RandomNumberGenerator.setRandomInstance(new Random());
    }

    @Test
    void testGenerateRandomNumbers() {
        int[] numbers = RandomNumberGenerator.generateRandomNumbers();

        assertNotNull(numbers);
        assertEquals(6, numbers.length);

        for (int number : numbers) {
            assertTrue(number >= 1 && number <= 99);
        }
    }

    @Test
    void testGenerateRandomNumbersNotEqual() {
        int[] numbers1 = RandomNumberGenerator.generateRandomNumbers();
        int[] numbers2 = RandomNumberGenerator.generateRandomNumbers();

        assertNotEquals(numbers1, numbers2);
    }
}