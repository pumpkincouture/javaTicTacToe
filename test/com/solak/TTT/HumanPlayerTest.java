package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HumanPlayerTest {
    private HumanPlayer humanPlayerTest;

    @Before
    public void setUp() {
    humanPlayerTest = new HumanPlayer("X");
    }

    @Test
    public void getHumanPlayerGamePiece() {
        assertEquals("X", humanPlayerTest.getGamePiece());
    }
}
