import java.util.HashMap;

/**
 * Created by administrator on 12/8/14.
 */
public class SetUp {
    private Player player1;
    private Player player2;
    private Board board;

    public SetUp(){
        this.player1 = new Player("X");
        this.player2 = new Player("O");
        this.board = new Board();
    }

    public Player getFirstPlayer() {
        return player1;
    }

    public Player getSecondPlayer() {
        return player2;
    }

    public HashMap getBoard() {
        return board.getBoard();
    }
}
