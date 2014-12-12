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
        test.placeMove("9", "X");
        test.placeMove("8", "X");
        test.placeMove("7", "O");
        test.placeMove("6", "O");
        test.placeMove("5", "X");
        test.placeMove("4", "O");
        test.placeMove("3", "X");
        test.placeMove("2", "O");
        test.placeMove("1", "X");
    }

    public void fillOneSpace() {
        test.placeMove("9", "");
        test.placeMove("8", "");
        test.placeMove("7", "");
        test.placeMove("6", "");
        test.placeMove("5", "");
        test.placeMove("4", "");
        test.placeMove("3", "");
        test.placeMove("2", "");
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
    public void checkTakenSpace() {
        fillOneSpace();

        assertEquals(false, test.isMoveValid("1"));
    }

    @Test
    public void checkIfBoardHasOpenSpaces() {
        assertEquals(true, test.isBoardOpen());
    }

    @Test
    public void checkIfBoardFullWithMockInputs () {
        fillBoard();

        assertEquals(false, test.isBoardOpen());
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
    public void checkEntireBoardForWinWithX() {
        fillBoard();

        assertEquals(true, test.isThereAWinner("X"));
    }

    @Test
    public void checkEntireBoardForWinWithO() {
        fillBoard();

        assertEquals(false, test.isThereAWinner("O"));
    }

    @Test
    public void checkEmptyIshBoardForWin() {
        fillOneSpace();

        assertEquals(false, test.isThereAWinner("O"));
    }
}