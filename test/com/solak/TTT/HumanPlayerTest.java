package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {
    private HumanPlayer humanPlayerTest;
    private MockUserInterface mockUI= new MockUserInterface();

    @Before
    public void setUp() {

    humanPlayerTest = new HumanPlayer("X", mockUI);
    }

    @Test
    public void getHumanPlayerGamePiece() {
        assertEquals("X", humanPlayerTest.getGamePiece());
    }

    @Test
    public void getHumanPlayerMove() {
        mockUI.addNextMove("5");
        assertEquals("5", humanPlayerTest.getMove());
    }
}
