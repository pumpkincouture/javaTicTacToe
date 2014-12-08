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

    public HashMap getBoard(){
        return boardCells;
    }

    public boolean isMoveValid(String answer){
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey() == answer) {
                return true;
            }
        }
    return false;
    }

    public HashMap placeMove(String answer, String gamePiece){
        boardCells.put(answer, gamePiece); return boardCells;
    }
}