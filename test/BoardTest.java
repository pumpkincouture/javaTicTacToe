import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by administrator on 12/4/14.
 */
public class BoardTest {
    Board test = new Board();

    @Test
    public void printBoardHash() {
        HashMap<String, String> boardCells = new LinkedHashMap();
        boardCells.put("9", "");
        boardCells.put("8", "");
        boardCells.put("7", "");
        boardCells.put("6", "");
        boardCells.put("5", "");
        boardCells.put("4", "");
        boardCells.put("3", "");
        boardCells.put("2", "");
        boardCells.put("1", "");

        assertEquals(boardCells, test.getBoard());
    }

    @Test
    public void checkIfSevenIsValid() { assertEquals(true, test.isMoveValid("7")); }

    @Test
    public void checkIfVIsValid() { assertEquals(false, test.isMoveValid("v")); }
}