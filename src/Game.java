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

    public void printStatements() {
        setup.getUI().printWelcomeMessage();
        setup.getUI().printGamePieceAssignment(setup.getFirstPlayer().getGamePiece(), setup.getSecondPlayer().getGamePiece());
        setup.getUI().printRules();
        setup.getUI().printStartingPlayer();
    }

    public void playGame() {

        while (boardIsNotFull()) {
          setup.getUI().printUserPrompt(setup.getFirstPlayer().getGamePiece());
          setup.getUI().printBoard(setup.getBoard().getBoardCells());
        }
    }

    public void switchPlayer() {

    }

    private boolean boardIsNotFull() {
        return !setup.getBoard().isBoardFull();
    }
}
