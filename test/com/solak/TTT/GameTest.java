package com.solak.TTT;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private Game gameTest;
    private Player player1 = new Player("X");
    private Player player2 = new Player("O");
    private Board board = new Board();
    private MockUserInterface mockUi = new MockUserInterface();

    private void fillBoard(String choice, String gamePiece) {
        gameTest.placeMoveOnBoard(choice, gamePiece);
    }

    @Before
    public void setUp() {
        gameTest = new Game(player1, player2, board, mockUi);
    }

    @Test
    public void displayWelcomeMessage() {
        gameTest.printWelcome();
        assertEquals(true, mockUi.isWelcomeMessageCalled());
    }

    @Test
    public void displayGamePieces() {
        gameTest.printGamePieces();
        assertEquals(true, mockUi.isGamePieceMessageCalled());
    }

    @Test
    public void displayStartingPlayer() {
        gameTest.printStartingPlayer();
        assertEquals(true, mockUi.isStartingPlayerCalled());
    }

    @Test
    public void getInitialBoardDisplay() {
        gameTest.displayBoard();
        assertEquals(true, mockUi.isDisplayBoardCalled());
    }

    @Test
    public void displayUserPrompt() {
        gameTest.printPlayerPrompt(player1.getGamePiece());
        assertEquals(true, mockUi.isUserPromptCalled());
    }
    @Test
    public void testIfMoveInvalid() {
        mockUi.addNextMove("ppppp");
        gameTest.printChoiceError(mockUi.captureChoice());
        assertEquals(true, mockUi.isDisplayInvalidMoveMessageCalled());
    }

    @Test
    public void testIfMoveValid() {
        mockUi.addNextMove("5");
        gameTest.printChoiceError(mockUi.captureChoice());
        assertEquals(false, mockUi.isDisplayInvalidMoveMessageCalled());
    }

    @Test
    public void testForWinner() {
        mockUi.addNextMove("1");
        mockUi.addNextMove("2");
        mockUi.addNextMove("3");

        for (int i = 0; i <= 2; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameTest.getWinnerName(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isWinnerStringCalled());
    }

    @Test
    public void testForCatsGame() {
        mockUi.addNextMove("1");
        mockUi.addNextMove("4");
        mockUi.addNextMove("3");
        mockUi.addNextMove("8");
        mockUi.addNextMove("9");
        mockUi.addNextMove("5");
        mockUi.addNextMove("2");
        mockUi.addNextMove("6");
        mockUi.addNextMove("7");

        for (int i = 0; i <= 4; i++) {
            fillBoard(mockUi.captureChoice(), player1.getGamePiece());
        }

        for (int i = 0; i <= 3; i++) {
            fillBoard(mockUi.captureChoice(), player2.getGamePiece());
        }

        gameTest.printGameWinner(gameTest.getWinnerName(player1.getGamePiece(), player2.getGamePiece()));
        assertEquals(true, mockUi.isCatsGameCalled());
    }
}
