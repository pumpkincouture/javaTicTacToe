package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    Game gameTest;
    Player player1 = new Player("X");
    Player player2 = new Player("O");
    Board board = new Board();
    MockUserInterface mockui = new MockUserInterface();

    @Before
    public void setUp() {
        gameTest = new Game(player1, player2, board, mockui);
    }

    @Test
    public void displayWelcomeMessage() {
        gameTest.printWelcome();
        assertEquals(true, mockui.isWelcomeMessageCalled());
    }

    @Test
    public void displayGamePieces() {
        gameTest.printGamePieces();
        assertEquals(true, mockui.isGamePieceMessageCalled());
    }

    @Test
    public void displayStartingPlayer() {
        gameTest.printStartingPlayer();
        assertEquals(true, mockui.isStartingPlayerCalled());
    }

    @Test
    public void getInitialBoardDisplay() {
        gameTest.displayBoard();
        assertEquals(true, mockui.isDisplayBoardCalled());
    }

    @Test
    public void getFirstPlayerMove() {
//        gameTest.chooseMove();
        mockui.addNextMove("5");
        System.out.println(mockui.captureChoice());
//        assertEquals(true, mockui.captureChoice());
    }
}
