package com.solak.TTT;

import java.util.*;

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

    public List<String> getOpenSpaces() {
        return getOpenCellLocations();
    }

    public int getBoardLength() {
        return boardCells.size();
    }

    public int getBoardSquareRoot(int boardLength) {
        long square = Math.round(Math.sqrt(boardLength));
        int squareRoot = (int) square;
        return squareRoot;
    }

    public boolean isMoveValid(String answer) {
        return validateCells(answer);
    }

    public boolean isBoardOpen() {
        return checkForOpenCells();
    }

    public HashMap placeMove(String answer, String gamePiece) {
        boardCells.put(answer, gamePiece);
        return boardCells;
    }

    public boolean isThereAWinner (String gamePiece) {
        for (LinkedHashMap<String, String> element : createBoardMatrix()) {
            if (checkBoardForWin(gamePiece, element) == getBoardSquareRoot(getBoardLength())) {
                return true;
            }
        }
        return false;
    }

    public String getWinningPlayer(String playerOne, String playerTwo) {
        String noWinner = "";
        for (LinkedHashMap<String, String> element : createBoardMatrix()) {
            if (checkBoardForWin(playerOne, element) == getBoardSquareRoot(getBoardLength())) {
                return playerOne;
            } else if (checkBoardForWin(playerTwo, element) == getBoardSquareRoot(getBoardLength())) {
                return playerTwo;
            }
        } return noWinner;
    }

    private ArrayList<LinkedHashMap<String, String>> createBoardMatrix () {
        ArrayList<LinkedHashMap<String, String>> boardMatrix = new ArrayList();
        boardMatrix.add(getPartOfBoard("1", "2", "3"));
        boardMatrix.add(getPartOfBoard("4", "5", "6"));
        boardMatrix.add(getPartOfBoard("7", "8", "9"));
        boardMatrix.add(getPartOfBoard("1", "5", "9"));
        boardMatrix.add(getPartOfBoard("3", "5", "7"));
        boardMatrix.add(getPartOfBoard("1", "4", "7"));
        boardMatrix.add(getPartOfBoard("2", "5", "8"));
        boardMatrix.add(getPartOfBoard("3", "6", "9"));

        return boardMatrix;
    }

    private boolean validateCells(String answer) {
        if (boardCells.containsKey(answer) && boardCells.containsValue("")) {
            return true;
        };
//        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
//            if (entry.getKey().equals(answer) && entry.getValue().isEmpty()) {
//                return true;
//            }
//        }
        return false;
    }

    private boolean checkForOpenCells() {
        for(Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getValue().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private List<String> getOpenCellLocations() {
        LinkedList<String> openCells = new LinkedList();
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getValue().isEmpty()) {
                openCells.push(entry.getKey());
            }
        }
        return openCells;
    }

    private LinkedHashMap<String, String> getPartOfBoard(String space1, String space2, String space3) {
        LinkedHashMap<String, String> boardPart = new LinkedHashMap();
        for (Map.Entry<String, String> entry : boardCells.entrySet()) {
            if (entry.getKey().equals(space1) || entry.getKey().equals(space2) || entry.getKey().equals(space3)) {
                boardPart.put(entry.getKey(), entry.getValue());
            }
        }
        return boardPart;
    }

    private int checkBoardForWin(String gamePiece, LinkedHashMap<String, String> boardPart) {
        int inARow = 0;

        for (Map.Entry<String, String> entry : boardPart.entrySet()) {
            if (entry.getValue().equals(gamePiece)) {
                inARow += 1;
            }
        }
        return inARow;
    }
}