package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class EasyComputerTest {
    private ComputerPlayer computerTest;

    private List<String> getSpace() {
        LinkedList<String> openCells = new LinkedList();
        openCells.push("9");
        return openCells;
    }

    @Before
    public void setUp() {
        computerTest = new ComputerPlayer("Z");
    }

    @Test
    public void getsGamePiece() {
        assertEquals("Z", computerTest.getGamePiece());
    }

    @Test
    public void getOpenSpace() {
        assertEquals("9", computerTest.chooseOpenSpace(getSpace()));
    }
}
