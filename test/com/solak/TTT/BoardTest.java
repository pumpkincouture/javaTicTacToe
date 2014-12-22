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

    private void simulateFilledBoard() {
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

    private boolean getCell(String boardCell, String gamePiece) {
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

        if (boardCells.containsKey(boardCell) && boardCells.containsValue(gamePiece)) {
            return true;
        }
        return false;

    }

    private void fillBoard(String choice, String gamePiece) {
        boardTest.placeMove(choice, gamePiece);
    }




    @Before
    public void setUp() {
        boardTest = new Board();
        testPlayer = new Player("X");
    }

    @Test
    public void returnBoardCellsAsHashMap() {
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

//    @Test
//    public void checkTakenSpace() {
//        fillBoard("1", "X");
//
//        assertEquals(false, boardTest.isMoveValid("1"));
//    }

    @Test
    public void checkIfBoardHasOpenSpaces() {
        assertEquals(true, boardTest.isBoardOpen());
    }

    @Test
    public void checkIfBoardFullWithMockInputs () {
        simulateFilledBoard();

        assertEquals(false, boardTest.isBoardOpen());
    }

    @Test
    public void placeMoveOnBoard() {
        boardTest.placeMove("9", testPlayer.getGamePiece());
        assertEquals(true, getCell("9", testPlayer.getGamePiece()));
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
        simulateFilledBoard();

        assertEquals(true, boardTest.isThereAWinner("X"));
    }

    @Test
    public void checkEntireBoardForWinWithO() {
        simulateFilledBoard();

        assertEquals(false, boardTest.isThereAWinner("O"));
    }

    @Test
    public void checkEmptyIshBoardForWin() {
        fillBoard("1", "X");

        assertEquals(false, boardTest.isThereAWinner("O"));
    }

    @Test
    public void checkBoardForWinInScenarioTwo() {
        fillBoard("1", "X");
        fillBoard("5", "X");
        fillBoard("9", "X");

        assertEquals(true, boardTest.isThereAWinner("X"));
    }

    @Test
    public void checkBoardForWinScenarioThree() {
        fillBoard("3", "O");
        fillBoard("5", "O");
        fillBoard("7", "O");

        assertEquals(true, boardTest.isThereAWinner("O"));
    }

    @Test
    public void checkBoardForWinScenarioFour() {
        fillBoard("1", "X");
        fillBoard("2", "X");
        fillBoard("3", "O");
        fillBoard("4", "O");
        fillBoard("5", "X");
        fillBoard("6", "");
        fillBoard("7", "X");
        fillBoard("8", "O");
        fillBoard("9", "O");

        assertEquals(false, boardTest.isThereAWinner("X"));
        assertEquals(false, boardTest.isThereAWinner("O"));
    }

    @Test
    public void getArrayOfEmptySpace() {
        fillBoard("1", "X");
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