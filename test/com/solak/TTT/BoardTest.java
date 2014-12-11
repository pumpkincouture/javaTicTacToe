package com.solak.TTT;

import com.solak.TTT.Board;
import com.solak.TTT.Player;
import jdk.nashorn.internal.ir.annotations.Ignore;
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
    Player testPlayer;

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
        testPlayer = new Player("X");
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

        assertEquals(boardCells, test.getBoardCells());
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
        boardCells.put("9", "X");
        boardCells.put("8", "");
        boardCells.put("7", "");
        boardCells.put("6", "");
        boardCells.put("5", "");
        boardCells.put("4", "");
        boardCells.put("3", "");
        boardCells.put("2", "");
        boardCells.put("1", "");

        assertEquals(boardCells, test.placeMove("9", testPlayer.getGamePiece()));
    }

    @Test
    public void checkSizeOfBoard() {
      assertEquals(3, test.getBoardSize());
    }

    @Test
    public void checkTopRow() {
        HashMap<String, String> testTopRow = new LinkedHashMap();
        testTopRow.put("3", "");
        testTopRow.put("2", "");
        testTopRow.put("1", "");

        assertEquals(testTopRow, test.getTopBoardRow());
    }

    @Test
    public void checkMiddleRow() {
        HashMap<String, String> testMidRow = new LinkedHashMap();
        testMidRow.put("4", "");
        testMidRow.put("5", "");
        testMidRow.put("6", "");

        assertEquals(testMidRow, test.getMiddleRow());
    }

    @Test
    public void checkBottomRow() {
        HashMap<String, String> testBottomRow = new LinkedHashMap();
        testBottomRow.put("7", "");
        testBottomRow.put("8", "");
        testBottomRow.put("9", "");

        assertEquals(testBottomRow, test.getBottomRow());
    }

    @Test
    public void checkLeftDiagonal() {
        HashMap<String, String> testLeftDiag = new LinkedHashMap();
        testLeftDiag.put("1", "");
        testLeftDiag.put("5", "");
        testLeftDiag.put("9", "");

        assertEquals(testLeftDiag, test.getLeftDiagonal());
    }

    @Test
    public void checkRightDiagonal() {
        HashMap<String, String> testRightDiag = new LinkedHashMap();
        testRightDiag.put("3", "");
        testRightDiag.put("5", "");
        testRightDiag.put("7", "");

        assertEquals(testRightDiag, test.getRightDiagonal());

    }
}