import java.util.LinkedHashMap;
import java.util.HashMap;
/**
 * Created by administrator on 12/9/14.
 */
public class Game {

    private SetUp setup;

    public Game() {
        this.setup = new SetUp();
    }

    public void playGame() {
        printIntro();
        getPlayerMoves(firstPlayerPiece());
        System.out.println("The game is over!");
    }

    private void getPlayerMoves(String playerPiece) {
        while (boardHasOpenSpaces()) {
            setup.getUI().printUserPrompt(playerPiece);
            displayBoard();
            String choice = chooseMove();
            if (isInvalidMove(choice)) {
                setup.getUI().printError();
                getPlayerMoves(playerPiece);
            } else {
                placeMoveOnBoard(choice, playerPiece);
                getPlayerMoves(switchPlayers(playerPiece));
            }
        }
    }

    private String switchPlayers(String startingPlayer) {
        if (startingPlayer == secondPlayerPiece()) {
            return firstPlayerPiece();
        } else {
            return secondPlayerPiece();
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

    private String chooseMove() {
        return setup.getUI().captureChoice();
    }

    private boolean isInvalidMove(String move) {
        return setup.getBoard().isMoveValid(move) == false;
    }

    private boolean boardHasOpenSpaces() {
        return !setup.getBoard().isBoardFull();
    }

    private void displayBoard() {
        setup.getUI().printBoard(setup.getBoard().getBoardCells());
    }

    private void placeMoveOnBoard(String answer, String gamePiece) {
        setup.getBoard().placeMove(answer, gamePiece);
    }
}