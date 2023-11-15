package games.lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComparatorTest {

    @Test
    void testCountCorrectNumbers() {

        int[] userNumbers = {1, 2, 3, 4, 5, 6};
        int[] generatedNumbers = {1, 7, 3, 8, 5, 9};

        int correctNumbers = NumberComparator.countCorrectNumbers(userNumbers, generatedNumbers);


        assertEquals(3, correctNumbers);
    }

    @Test
    void testCountCorrectNumbersNoMatches() {

        int[] userNumbers = {11, 22, 33, 44, 55, 66};
        int[] generatedNumbers = {1, 7, 3, 8, 5, 9};

        int correctNumbers = NumberComparator.countCorrectNumbers(userNumbers, generatedNumbers);

        assertEquals(0, correctNumbers);
    }

    @Test
    void testCountCorrectNumbersAllMatches() {
        int[] userNumbers = {1, 7, 3, 8, 5, 9};
        int[] generatedNumbers = {1, 7, 3, 8, 5, 9};

        int correctNumbers = NumberComparator.countCorrectNumbers(userNumbers, generatedNumbers);
        assertEquals(6, correctNumbers);
    }
}