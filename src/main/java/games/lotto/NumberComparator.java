package games.lotto;

import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberComparator {
    public int countCorrectNumbers(int[] userNumbers, int[] generatedNumbers) {
        int correctNumbers = 0;

        for (int userNumber : userNumbers) {
            for (int generatedNumber : generatedNumbers) {
                if (userNumber == generatedNumber) {
                    correctNumbers++;
                    break;
                }
            }
        }
        return correctNumbers;
    }
}





