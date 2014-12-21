package com.solak.TTT;

import java.util.Random;

public class ComputerPlayer extends Player {
    private Random randomGenerator;
    private Board board;

    public ComputerPlayer(String gamePiece, Board board) {
        super(gamePiece);
        this.board = board;
        randomGenerator = new Random();
    }

    public String getMove() {
        return chooseOpenSpace();
    }

    private String chooseOpenSpace() {
        int index = randomGenerator.nextInt(board.getOpenSpaces().size());
        String space = board.getOpenSpaces().get(index);
        return space;
    }
}
