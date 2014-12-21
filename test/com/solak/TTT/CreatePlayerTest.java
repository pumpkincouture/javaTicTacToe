package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CreatePlayerTest {
    private MockUserInterface mockui;
    private CreatePlayer createPlayerTest;

    @Before
    public void setUp() {
        mockui = new MockUserInterface();
        createPlayerTest = new CreatePlayer(mockui);
    }

    @Test
    public void askUserForChoice() {
        mockui.addNextMove("5");
        assertEquals("5", createPlayerTest.chooseOpponent());
    }

    @Test
    public void validateOpponentChoice() {
        mockui.addNextMove("c");
        assertEquals("C", createPlayerTest.validateChoice(createPlayerTest.chooseOpponent()));
    }
}
