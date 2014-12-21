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
    public void checkThatComputerOpponentIsCreated() {
        mockui.addNextMove("c");
        assertEquals("ComputerPlayer", createPlayerTest.getChosenOpponent().getClass().getSimpleName());
    }

    @Test
    public void checkThatHumanOpponentIsCreated() {
        mockui.addNextMove("h");
        assertEquals("HumanPlayer", createPlayerTest.getChosenOpponent().getClass().getSimpleName());
    }

    @Test
    public void promptAgainIfInvalidOutput() {
        mockui.addNextMove("f");
        mockui.addNextMove("-");
        mockui.addNextMove("c");
        createPlayerTest.getChosenOpponent();

        assertEquals(true, mockui.isDisplayInvalidMoveMessageCalled());
        assertEquals("ComputerPlayer", createPlayerTest.getAssignedOpponent().getClass().getSimpleName());
    }
}
