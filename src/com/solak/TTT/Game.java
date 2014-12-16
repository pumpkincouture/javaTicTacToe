package com.solak.TTT;

import java.util.LinkedHashMap;
import java.util.HashMap;

public class Game {

    private SetUp setup;

    public Game() {
        this.setup = new SetUp();
    }

    public void startGame() {
        playGame();
        printGameWinner(getWinnerName(firstPlayerPiece(), secondPlayerPiece()));
        displayBoard();
    }

    private boolean playGame() {
        printIntro();
          while (boardHasOpenSpaces()) {
              getFirstMove(firstPlayerPiece());
              if (thereIsAWinner(firstPlayerPiece()) || !boardHasOpenSpaces()) {
                  return false;
              }
              getSecondMove(secondPlayerPiece());
              if (thereIsAWinner(secondPlayerPiece())) {
                  return false;
              }
          }
        return true;
    }

    private void getFirstMove(String playerOne) {
        printPlayerPrompt(playerOne);
        displayBoard();
        String choice = getPlayerOne();
          if (isInvalidMove(choice)) {
            printChoiceError();
            getFirstMove((playerOne));
        } else {
            placeMoveOnBoard(choice, firstPlayerPiece());
        }
    }

    private void getSecondMove(String playerTwo) {
        printPlayerPrompt(playerTwo);
        displayBoard();
        String choice = getPlayerOne();
          if (isInvalidMove(choice)) {
            printChoiceError();
            getSecondMove(playerTwo);
        } else {
            placeMoveOnBoard(choice, secondPlayerPiece());
        }
    }

    private String getWinnerName(String playerOne, String playerTwo) {
        return setup.getBoard().getWinningPlayer(playerOne, playerTwo);
    }

    private String getPlayerOne() {
        return chooseMove();
    }

    private void printPlayerPrompt(String playerPiece) {
        setup.getUI().printUserPrompt(playerPiece);
    }

    private void printGameWinner(String gamePiece) {
          if (gamePiece.isEmpty()) {
            setup.getUI().printCatsGame();
        } else {
            setup.getUI().printWinner(gamePiece);
        }
    }

    private String firstPlayerPiece() {
        return setup.getFirstPlayer().getGamePiece();
    }

    private String secondPlayerPiece() {
        return setup.getSecondPlayer().getGamePiece();
    }

    private void printIntro() {
        setup.getUI().printWelcomeMessage();
        setup.getUI().printGamePieceAssignment(firstPlayerPiece(), secondPlayerPiece());
        setup.getUI().printRules();
        setup.getUI().printStartingPlayer(firstPlayerPiece());
    }

    private void printChoiceError() {
        setup.getUI().printError();
    }

    private String chooseMove() {
        return setup.getUI().captureChoice();
    }

    private boolean isInvalidMove(String move) {
        return setup.getBoard().isMoveValid(move) == false;
    }

    private boolean thereIsAWinner(String gamePiece) {
        return setup.getBoard().isThereAWinner(gamePiece);
    }

    private boolean boardHasOpenSpaces() {
        return setup.getBoard().isBoardOpen();
    }

    private void displayBoard() {
        setup.getUI().printBoard(setup.getBoard().getBoardCells());
    }

    private void placeMoveOnBoard(String answer, String gamePiece) {
        setup.getBoard().placeMove(answer, gamePiece);
    }
}