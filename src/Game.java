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
        while (boardIsNotFull()) {
            getPlayerMoves(firstPlayerPiece());
        }
        System.out.println("The game is over!");
    }

    public void getPlayerMoves(String playerPiece) {
         setup.getUI().printUserPrompt(playerPiece);
         displayBoard();
         String choice = chooseMove();
          if (isInvalidMove(choice)) {
              System.out.println("IT'S NOT VALID");
              setup.getUI().printError();
          } else {
              System.out.println("I'm in the else statement");
              placeMoveOnBoard(choice, playerPiece);
          }
    }

    private String firstPlayerPiece() {
        return setup.getFirstPlayer().getGamePiece();
    }

//    private String switchPlayers() {
//
//    }

    private void printIntro() {
        setup.getUI().printWelcomeMessage();
        setup.getUI().printGamePieceAssignment(setup.getFirstPlayer().getGamePiece(), setup.getSecondPlayer().getGamePiece());
        setup.getUI().printRules();
        setup.getUI().printStartingPlayer();
    }

    private String chooseMove() {
        return setup.getUI().captureChoice();
    }

    private boolean isInvalidMove(String move) {
        return setup.getBoard().isMoveValid(move) == false;
    }

    private boolean boardIsNotFull() {
        return !setup.getBoard().isBoardFull();
    }

    private void displayBoard() {
        setup.getUI().printBoard(setup.getBoard().getBoardCells());
    }

    private void placeMoveOnBoard(String answer, String gamePiece) {
        setup.getBoard().placeMove(answer, gamePiece);
    }

}
