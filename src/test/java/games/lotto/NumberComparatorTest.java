package games.lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class NumberComparatorTest {

    @Test
    void testCountCorrectNumbers() {
        // Przykładowe dane
        int[] userNumbers = {1, 2, 3, 4, 5, 6};
        int[] generatedNumbers = {1, 7, 3, 8, 5, 9};

        // Wywołanie metody do testowania
        int correctNumbers = NumberComparator.countCorrectNumbers(userNumbers, generatedNumbers);

        // Sprawdzenie oczekiwanych wyników
        assertEquals(3, correctNumbers);
    }

    @Test
    void testCountCorrectNumbersNoMatches() {
        // Przykładowe dane bez dopasowań
        int[] userNumbers = {11, 22, 33, 44, 55, 66};
        int[] generatedNumbers = {1, 7, 3, 8, 5, 9};

        // Wywołanie metody do testowania
        int correctNumbers = NumberComparator.countCorrectNumbers(userNumbers, generatedNumbers);

        // Sprawdzenie oczekiwanych wyników (brak dopasowań)
        assertEquals(0, correctNumbers);
    }

    @Test
    void testCountCorrectNumbersAllMatches() {
        // Przykładowe dane, wszystkie liczby pasują
        int[] userNumbers = {1, 7, 3, 8, 5, 9};
        int[] generatedNumbers = {1, 7, 3, 8, 5, 9};

        // Wywołanie metody do testowania
        int correctNumbers = NumberComparator.countCorrectNumbers(userNumbers, generatedNumbers);

        // Sprawdzenie oczekiwanych wyników (wszystkie liczby pasują)
        assertEquals(6, correctNumbers);
    }
}