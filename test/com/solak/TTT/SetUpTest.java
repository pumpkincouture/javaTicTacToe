package com.solak.TTT;

import com.solak.TTT.Board;
import com.solak.TTT.Player;
import com.solak.TTT.SetUp;
import com.solak.TTT.UserInterface;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by administrator on 12/8/14.
 */
public class SetUpTest {
    SetUp test;
    Player player1;
    Player player2;
    Board boardTest;
    UserInterface uiTest;

    @Before
    public void createTest() {
        player1 = new Player("X");
        player2 = new Player("O");
        boardTest = new Board();
        uiTest = new UserInterface();
        test = new SetUp();
    }

    @Test
    public void checkGamePieceOfFirstPlayer() {
        assertEquals(player1.getGamePiece(), test.getFirstPlayer().getGamePiece());
    }

    @Test
    public void checkGamePieceOfSecondPlayer() {
        assertEquals(player2.getGamePiece(), test.getSecondPlayer().getGamePiece());
    }

    @Test
    public void checkBoardSpaces() {
        HashMap<String, String> testCells = new LinkedHashMap();
        testCells.put("9", "");
        testCells.put("8", "");
        testCells.put("7", "");
        testCells.put("6", "");
        testCells.put("5", "");
        testCells.put("4", "");
        testCells.put("3", "");
        testCells.put("2", "");
        testCells.put("1", "");

        assertEquals(testCells, test.getBoard().getBoardCells());
    }
}
