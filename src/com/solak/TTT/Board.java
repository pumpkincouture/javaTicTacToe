package com.solak.TTT;

import javax.xml.bind.SchemaOutputResolver;
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

    public int getBoardSize() {
        long square = Math.round(Math.sqrt(boardCells.size()));
        int squareRoot = (int) square;
        return squareRoot;

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


    public LinkedHashMap<String, String> getTopBoardRow() {
        return getpartOfBoard("1", "2", "3");
    }

    public LinkedHashMap<String, String> getMiddleRow() {
        return getpartOfBoard("4", "5", "6");
    }

    public LinkedHashMap<String, String> getBottomRow() {
        return getpartOfBoard("7", "8", "9");
    }

    public LinkedHashMap<String, String> getLeftDiagonal() {
        return getpartOfBoard("1", "5", "9");
    }

    public LinkedHashMap<String, String> getRightDiagonal() {
        return getpartOfBoard("3", "5", "7");
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

    private LinkedHashMap<String, String> getpartOfBoard(String space1, String space2, String space3) {
        LinkedHashMap<String, String> boardPart = new LinkedHashMap();
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey().equals(space1) || entry.getKey().equals(space2) || entry.getKey().equals(space3)) {
                boardPart.put(entry.getKey(), entry.getValue());
            }
        }
        return boardPart;
    }

    private int checkBoard(String gamePiece, LinkedHashMap<String, String> boardPart) {
        int threeInARow = 0;

        for (Map.Entry<String, String> entry : boardPart.entrySet()) {
            if (entry.getValue().equals(gamePiece)) {
                threeInARow += 1;

            }
        }
        return threeInARow;
    }
}