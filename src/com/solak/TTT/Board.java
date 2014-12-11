package com.solak.TTT;

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

    public HashMap getTopBoardRow() {
        HashMap<String, String> topRow = new LinkedHashMap();
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey().equals("1") || entry.getKey().equals("2") || entry.getKey().equals("3")) {
                topRow.put(entry.getKey(), entry.getValue());
            }

        } return topRow;
    }

    public HashMap getMiddleRow() {
        HashMap<String, String> midRow = new LinkedHashMap();
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey().equals("4") || entry.getKey().equals("5") || entry.getKey().equals("6")) {
                midRow.put(entry.getKey(), entry.getValue());
            }
        } return midRow;
    }

    public HashMap getBottomRow() {
        HashMap<String, String> bottomRow = new LinkedHashMap();
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey().equals("7") || entry.getKey().equals("8") || entry.getKey().equals("9")) {
                bottomRow.put(entry.getKey(), entry.getValue());
            }
        } return bottomRow;
    }

    public HashMap getLeftDiagonal() {
        HashMap<String, String> leftDiag = new LinkedHashMap();
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey().equals("1") || entry.getKey().equals("5") || entry.getKey().equals("9")) {
                leftDiag.put(entry.getKey(), entry.getValue());
            }
        } return leftDiag;
    }

    public HashMap getRightDiagonal() {
        HashMap<String, String> rightDiag = new LinkedHashMap();
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey().equals("3") || entry.getKey().equals("5") || entry.getKey().equals("7")) {
                rightDiag.put(entry.getKey(), entry.getValue());
            }
        } return rightDiag;
    }
}