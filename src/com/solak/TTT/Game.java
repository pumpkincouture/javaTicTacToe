package com.solak.TTT;

public class Game {
    private Player player1;
    private Player player2;
    private Board board;
    private CommandLineInterface userinterface;

    public Game(Player player1, Player player2, Board board, CommandLineInterface userinterface) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.userinterface = userinterface;
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
        return board.getWinningPlayer(playerOne, playerTwo);
    }

    private String getPlayerOne() {
        return chooseMove();
    }

    private void printPlayerPrompt(String playerPiece) {
        userinterface.printUserPrompt(playerPiece);
    }

    private void printGameWinner(String gamePiece) {
          if (gamePiece.isEmpty()) {
            userinterface.printCatsGame();
        } else {
            userinterface.printWinner(gamePiece);
        }
    }

    private String firstPlayerPiece() {
        return player1.getGamePiece();
    }

    private String secondPlayerPiece() {
        return player2.getGamePiece();
    }

    private void printIntro() {
        userinterface.printWelcomeMessage();
        userinterface.printGamePieceAssignment(firstPlayerPiece(), secondPlayerPiece());
        userinterface.printRules();
        userinterface.printStartingPlayer(firstPlayerPiece());
    }

    private void printChoiceError() {
        userinterface.printError();
    }

    private String chooseMove() {
        return userinterface.captureChoice();
    }

    private boolean isInvalidMove(String move) {
        return board.isMoveValid(move) == false;
    }

    private boolean thereIsAWinner(String gamePiece) {
        return board.isThereAWinner(gamePiece);
    }

    private boolean boardHasOpenSpaces() {
        return board.isBoardOpen();
    }

    private void displayBoard() {
        userinterface.printBoard(board.getBoardCells());
    }

    private void placeMoveOnBoard(String answer, String gamePiece) {
        board.placeMove(answer, gamePiece);
    }
}