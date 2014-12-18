package com.solak.TTT;

import java.util.HashMap;

public interface UserInterface {

    public String captureChoice();

    public void printWelcomeMessage();

    public void printGamePieceAssignment(String playerOnePiece, String playerTwoPiece);

    public void printStartingPlayer(String gamePiece);

    public void printUserPrompt(String gamePiece);

    public void printBoard(HashMap<String, String> boardCells);

    public void printError();
}
