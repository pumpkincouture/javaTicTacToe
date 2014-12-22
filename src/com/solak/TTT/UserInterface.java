package com.solak.TTT;

import java.util.HashMap;

public interface UserInterface {

    public String captureChoice();

    public void printChosenOpponent(String opponentName);

    public void printWelcomeMessage();

    public void printGamePieceAssignment(String onePiece, String playerOnePiece, String playerTwoPiece);

    public void printStartingPlayer(String gamePiece);

    public void promptForOpponent();

    public void printUserPrompt(String playerName, String gamePiece);

    public void printBoard(HashMap<String, String> boardCells);

    public void printError(String choice);

    public void printWinner(String gamePiece);

    public void printCatsGame();
}
