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
            getSecondMove();
            if (thereIsAWinner(secondPlayerPiece())) {
                return false;
            }
        }
        return true;
    }

    public void getFirstMove(String playerOne) {
        printPlayerPrompt(player1.getClass().getSimpleName(), playerOne);
        displayBoard();
        String choice = getPlayerOne();
        if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getFirstMove((playerOne));
        } else {
            placeMoveOnBoard(choice, firstPlayerPiece());
        }
    }

    public void getSecondMove() {
        if (player2.getClass().getSimpleName().equals("HumanPlayer")) {
            getHumanOpponentMove();
        } else {
            getComputerOpponentMove();
        }
    }

    private void getHumanOpponentMove() {
        printPlayerPrompt(player2.getClass().getSimpleName(), player2.getGamePiece());
        displayBoard();
        String choice = getPlayerOne();
        if (isInvalidMove(choice)) {
            printChoiceError(choice);
            getSecondMove();
        } else {
            placeMoveOnBoard(choice, secondPlayerPiece());
        }
    }

    private void getComputerOpponentMove() {
        board.placeMove(player2.getMove(), player2.getGamePiece());
    }

    public String getWinnerName(String playerOne, String playerTwo) {
        return board.getWinningPlayer(playerOne, playerTwo);
    }

    public String getPlayerOne() {
        return chooseMove();
    }

    public void printPlayerPrompt(String playerName, String gamePiece) {
        userinterface.printUserPrompt(playerName, gamePiece);
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
        userinterface.printGamePieceAssignment(firstPlayerPiece(), player2.getClass().getSimpleName(), secondPlayerPiece());
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