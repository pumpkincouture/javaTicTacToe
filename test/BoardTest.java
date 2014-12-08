import org.junit.Test;
import org.junit.Before;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by administrator on 12/4/14.
 */
public class BoardTest {
    Board test;

    public void fillBoard() {
        test.placeMove("9", "O");
        test.placeMove("8", "X");
        test.placeMove("7", "O");
        test.placeMove("6", "O");
        test.placeMove("5", "X");
        test.placeMove("4", "O");
        test.placeMove("3", "X");
        test.placeMove("2", "O");
        test.placeMove("1", "X");
    }

    @Before
    public void setUp() {
        test = new Board();
    }

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
    public void checkIfSevenIsValid() {
        assertEquals(true, test.isMoveValid("7"));
    }

    @Test
    public void checkIfVIsValid() {
        assertEquals(false, test.isMoveValid("v"));
    }

    @Test
    public void checkIfBoarFull() {
        assertEquals(false, test.isBoardFull());
    }

    @Test
    public void checkIfBoardFullWithMockInputs () {
        fillBoard();

        assertEquals(true, test.isBoardFull());
    }

    @Test
    public void placeMoveOnBoard() {
        HashMap<String, String> boardCells = new LinkedHashMap();
        boardCells.put("9", "O");
        boardCells.put("8", "");
        boardCells.put("7", "");
        boardCells.put("6", "");
        boardCells.put("5", "");
        boardCells.put("4", "");
        boardCells.put("3", "");
        boardCells.put("2", "");
        boardCells.put("1", "");

        assertEquals(boardCells, test.placeMove("9", "O"));
    }
}