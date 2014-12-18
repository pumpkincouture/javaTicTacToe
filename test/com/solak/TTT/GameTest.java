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

    public void fillBoard(String choice, String gamePiece) {
        gameTest.placeMoveOnBoard(choice, gamePiece);
    }

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
    public void displayUserPrompt() {
        gameTest.printPlayerPrompt(player1.getGamePiece());
        assertEquals(true, mockui.isUserPromptCalled());
    }
    @Test
    public void testIfMoveInvalid() {
        mockui.addNextMove("ppppp");
        gameTest.printChoiceError(mockui.captureChoice());
        assertEquals(true, mockui.isDisplayInvalidMoveMessageCalled());
    }

    @Test
    public void testIfMoveValid() {
        mockui.addNextMove("5");
        gameTest.printChoiceError(mockui.captureChoice());
        assertEquals(false, mockui.isDisplayInvalidMoveMessageCalled());
    }

    @Test
    public void testForWinner() {
        mockui.addNextMove("1");
        mockui.addNextMove("2");
        mockui.addNextMove("3");

        for (int i = 0; i <= 2; i++) {
            fillBoard(mockui.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameTest.getWinnerName(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockui.isWinnerStringCalled());
    }

    @Test
    public void testForCatsGame() {
        mockui.addNextMove("1");
        mockui.addNextMove("4");
        mockui.addNextMove("3");
        mockui.addNextMove("8");
        mockui.addNextMove("9");
        mockui.addNextMove("5");
        mockui.addNextMove("2");
        mockui.addNextMove("6");
        mockui.addNextMove("7");

        for (int i = 0; i <= 4; i++) {
            fillBoard(mockui.captureChoice(), player1.getGamePiece());
        }

        for (int i = 0; i <= 3; i++) {
            fillBoard(mockui.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameTest.getWinnerName(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockui.isCatsGameCalled());
    }
}
