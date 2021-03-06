package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {
    private HumanPlayer humanPlayerTest;
    private MockUserInterface mockUI;

    @Before
    public void setUp() {
        mockUI =  new MockUserInterface();
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
