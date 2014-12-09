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
            getPlayerMoves();
        }
    }

    public void getPlayerMoves() {
         setup.getUI().printUserPrompt(setup.getFirstPlayer().getGamePiece());
         displayBoard();
          if (invalidMove()) {
              System.out.println("IT'S NOT VALID");
              setup.getUI().printError();
          } else {

          }
    }

    private void printIntro() {
        setup.getUI().printWelcomeMessage();
        setup.getUI().printGamePieceAssignment(setup.getFirstPlayer().getGamePiece(), setup.getSecondPlayer().getGamePiece());
        setup.getUI().printRules();
        setup.getUI().printStartingPlayer();
    }

    private boolean invalidMove() {
        return setup.getBoard().isMoveValid(setup.getUI().captureChoice()) == false;
    }

    private boolean boardIsNotFull() {
        return !setup.getBoard().isBoardFull();
    }

    private void displayBoard() {
        setup.getUI().printBoard(setup.getBoard().getBoardCells());
    }


}
