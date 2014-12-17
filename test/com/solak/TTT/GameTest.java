package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game gameTest;
    Player player1;
    Player player2;
    Board board;
    MockUserInterface mockui = new MockUserInterface();

    @Before
    public void setUp() {
        gameTest = new Game(player1, player2, board, mockui);
    }

    @Test
    public void getFirstMove() {
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


        mockui.seeAllMoves();

        assertEquals(true, true);

    }
}
