package games.paperRockAndScissors;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class PaperRockAndScissorsTest {

    @Test
    void testPlay() {
        PaperRockAndScissors paperRockAndScissors = new PaperRockAndScissors();
        assertDoesNotThrow(paperRockAndScissors::play);
    }
}