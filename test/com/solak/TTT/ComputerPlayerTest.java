package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ComputerPlayerTest {
    private ComputerPlayer computerPlayerTest;
    private Board board;

    private void fillBoard() {
        board.placeMove("8", "X");
        board.placeMove("7", "O");
        board.placeMove("6", "O");
        board.placeMove("5", "X");
        board.placeMove("4", "O");
        board.placeMove("3", "X");
        board.placeMove("2", "O");
        board.placeMove("1", "X");
    }

    @Before
    public void setUp() {
        board = new Board();
        computerPlayerTest = new ComputerPlayer("Z", board);
    }

    @Test
    public void getsGamePiece() {
        assertEquals("Z", computerPlayerTest.getGamePiece());
    }

    @Test
    public void getOpenSpace() {
        fillBoard();
        assertEquals("9", computerPlayerTest.getMove());
    }
}
