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

    public void getFirstMove(String playerOne) {
        printPlayerPrompt(playerOne);
        displayBoard();
        String choice = getPlayerOne();
          if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getFirstMove((playerOne));
        } else {
            placeMoveOnBoard(choice, firstPlayerPiece());
        }
    }

    public void getSecondMove(String playerTwo) {
        printPlayerPrompt(playerTwo);
        displayBoard();
        String choice = getPlayerOne();
          if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getSecondMove(playerTwo);
        } else {
            placeMoveOnBoard(choice, secondPlayerPiece());
        }
    }

    public String getWinnerName(String playerOne, String playerTwo) {
        return board.getWinningPlayer(playerOne, playerTwo);
    }

    public String getPlayerOne() {
        return chooseMove();
    }

    public void printPlayerPrompt(String playerPiece) {
        userinterface.printUserPrompt(playerPiece);
    }

    public void printGameWinner(String gamePiece) {
          if (gamePiece.isEmpty()) {
            userinterface.printCatsGame();
        } else {
            userinterface.printWinner(gamePiece);
        }
    }

    public String firstPlayerPiece() {
        return player1.getGamePiece();
    }

    public String secondPlayerPiece() {
        return player2.getGamePiece();
    }

    public void printIntro() {
        printWelcome();
        printGamePieces();
        printStartingPlayer();
    }

    public void printWelcome() {
        userinterface.printWelcomeMessage();
    }

    public void printGamePieces() {
        userinterface.printGamePieceAssignment(firstPlayerPiece(), secondPlayerPiece());
    }

    public void printStartingPlayer() {
        userinterface.printStartingPlayer(firstPlayerPiece());
    }

    public void printChoiceError(String move) {
        if (isInvalidMove(move)) {
            userinterface.printError(move);
        }
    }

    public String chooseMove() {
        return userinterface.captureChoice();
    }

    public boolean isInvalidMove(String move) {
        return board.isMoveValid(move) == false;
    }

    public boolean thereIsAWinner(String gamePiece) {
        return board.isThereAWinner(gamePiece);
    }

    public boolean boardHasOpenSpaces() {
        return board.isBoardOpen();
    }

    public void displayBoard() {
        userinterface.printBoard(board.getBoardCells());
    }

    public void placeMoveOnBoard(String answer, String gamePiece) {
        board.placeMove(answer, gamePiece);
    }
}