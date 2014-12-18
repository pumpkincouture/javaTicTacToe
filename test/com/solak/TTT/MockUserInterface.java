package com.solak.TTT;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class MockUserInterface extends CommandLineInterface implements UserInterface {

    private List<String> nextMoves = new LinkedList<String>();
    private boolean displayWelcomePromptCalled = false;
    private boolean displayGamePieceAssignmentCalled = false;
    private boolean displayStartingPlayerCalled = false;
    private boolean displayUserPromptCalled = false;
    private boolean displayInvalidMoveMessageCalled = false;
    private boolean displayBoardCalled = false;


    // ["1", "2", "4", "3", "7"] - player 1 wins
    // ["fpoksdfpoksdf", "1"] - invalid move, then valid move

    public void addNextMove(String move) {
        nextMoves.add(move);
    }

    public String captureChoice() {
        return nextMoves.remove(0);
    }

    public void printWelcomeMessage() {
        displayWelcomePromptCalled = true;
    }

    public void printGamePieceAssignment(String playerOnePiece, String playerTwoPiece){
        displayGamePieceAssignmentCalled = true;
    }

    public void  printStartingPlayer(String gamePiece) {
        displayStartingPlayerCalled = true;
    }

    public void printUserPrompt(String gamePiece) {
        displayUserPromptCalled = true;
    }

    public void printError() {
        displayInvalidMoveMessageCalled = true;
    }

    public void printBoard(HashMap<String, String> boardCells) {
        displayBoardCalled = true;
    }

    public boolean isWelcomeMessageCalled() {
        return displayWelcomePromptCalled;
    }

    public boolean isGamePieceMessageCalled() {
        return displayGamePieceAssignmentCalled;
    }

    public boolean isStartingPlayerCalled() {
        return displayStartingPlayerCalled;
    }

    public boolean isDisplayBoardCalled() {
        return displayBoardCalled;
    }

    public boolean isUserPromptCalled() {
        return displayUserPromptCalled;
    }

    public boolean isDisplayInvalidMoveMessageCalled() {
        return displayInvalidMoveMessageCalled;
    }
}