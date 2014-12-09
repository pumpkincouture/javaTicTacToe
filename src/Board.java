import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by administrator on 12/4/14.
 */
public class Board {

    private HashMap<String, String> boardCells = new LinkedHashMap();

    public Board() {
        boardCells.put("9", "");
        boardCells.put("8", "");
        boardCells.put("7", "");
        boardCells.put("6", "");
        boardCells.put("5", "");
        boardCells.put("4", "");
        boardCells.put("3", "");
        boardCells.put("2", "");
        boardCells.put("1", "");
    }

    public HashMap getBoardCells() {
        return boardCells;
    }

    public boolean isMoveValid(String answer) {
       return validateCells(answer);
    }

    public boolean isBoardFull() {
        return checkForOpenCells();
    }

    public HashMap placeMove(String answer, String gamePiece) {
        boardCells.put(answer, gamePiece);
        return boardCells;
    }

    private boolean validateCells(String answer) {
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey().equals(answer)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkForOpenCells() {
        for(Map.Entry<String, String> entry : boardCells.entrySet()) {
            String emptySpace = "";
            if (entry.getValue().equals(emptySpace)) {
                return false;
            }
        }
        return true;
    }
}