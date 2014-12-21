package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private Board boardTest;
    private Player testPlayer;

    private void fillBoard() {
        boardTest.placeMove("9", "X");
        boardTest.placeMove("8", "X");
        boardTest.placeMove("7", "O");
        boardTest.placeMove("6", "O");
        boardTest.placeMove("5", "X");
        boardTest.placeMove("4", "O");
        boardTest.placeMove("3", "X");
        boardTest.placeMove("2", "O");
        boardTest.placeMove("1", "X");
    }

    private void fillOneSpace() {
        boardTest.placeMove("9", "");
        boardTest.placeMove("8", "");
        boardTest.placeMove("7", "");
        boardTest.placeMove("6", "");
        boardTest.placeMove("5", "");
        boardTest.placeMove("4", "");
        boardTest.placeMove("3", "");
        boardTest.placeMove("2", "");
        boardTest.placeMove("1", "X");
    }

    @Before
    public void setUp() {
        boardTest = new Board();
        testPlayer = new Player("X");
    }

    @Test
    public void returnBoardCellsAsHash() {
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

        assertEquals(boardCells, boardTest.getBoardCells());
    }

    @Test
    public void checkIfSevenIsValid() {
        assertEquals(true, boardTest.isMoveValid("7"));
    }

    @Test
    public void checkIfVIsValid() {
        assertEquals(false, boardTest.isMoveValid("v"));
    }

    @Test
    public void checkTakenSpace() {
        fillOneSpace();

        assertEquals(false, boardTest.isMoveValid("1"));
    }

    @Test
    public void checkIfBoardHasOpenSpaces() {
        assertEquals(true, boardTest.isBoardOpen());
    }

    @Test
    public void checkIfBoardFullWithMockInputs () {
        fillBoard();

        assertEquals(false, boardTest.isBoardOpen());
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

        assertEquals(boardCells, boardTest.placeMove("9", testPlayer.getGamePiece()));
    }

    @Test
    public void getLengthOfBoard() {
        assertEquals(9, boardTest.getBoardLength());
    }

    @Test
    public void checkBoardSquareRoot() {
        assertEquals(3, boardTest.getBoardSquareRoot(9));
    }

    @Test
    public void checkEntireBoardForWinWithX() {
        fillBoard();

        assertEquals(true, boardTest.isThereAWinner("X"));
    }

    @Test
    public void checkEntireBoardForWinWithO() {
        fillBoard();

        assertEquals(false, boardTest.isThereAWinner("O"));
    }

    @Test
    public void checkEmptyIshBoardForWin() {
        fillOneSpace();

        assertEquals(false, boardTest.isThereAWinner("O"));
    }

    @Test
    public void getArrayofEmptySpace() {
        fillOneSpace();
        LinkedList<String> openCells = new LinkedList();

        openCells.push("9");
        openCells.push("8");
        openCells.push("7");
        openCells.push("6");
        openCells.push("5");
        openCells.push("4");
        openCells.push("3");
        openCells.push("2");

        assertEquals(openCells, boardTest.getOpenSpaces());
    }
}