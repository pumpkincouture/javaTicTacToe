import org.w3c.dom.ranges.Range;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.IntStream;

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

    public int getBoardSize() {
        long square = Math.round(Math.sqrt(boardCells.size()));
        int squareRoot = (int) square;
        return squareRoot;

    }

    public HashMap getTopBoardRow() {
        HashMap<Integer, String> topRowCells = new LinkedHashMap();
        topRowCells.put(9, "");
        topRowCells.put(8, "");
        topRowCells.put(7, "");
        topRowCells.put(6, "");
        topRowCells.put(5, "");
        topRowCells.put(4, "");
        topRowCells.put(3, "");
        topRowCells.put(2, "");
        topRowCells.put(1, "");

        for (Map.Entry<Integer, String> entry : topRowCells.entrySet()) {
            if (entry.getKey().equals(getBoardSize() - 1) || entry.getKey().equals(getBoardSize() - 2)) {
                System.out.println(entry);
            }

        } return topRowCells;
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
            if (entry.getKey().equals(answer) && entry.getValue().equals("")) {
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