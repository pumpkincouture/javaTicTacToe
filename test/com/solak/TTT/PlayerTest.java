package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {
    Player test;

    @Before
    public void setUp() {
        test = new Player("X");
    }

    @Test
    public void printPiece() {
        assertEquals("X", test.getGamePiece());
    }
}
