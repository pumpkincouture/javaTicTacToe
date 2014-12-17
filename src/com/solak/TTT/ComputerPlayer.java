package com.solak.TTT;

import java.util.List;
import java.util.Random;

public class ComputerPlayer {
    private String gamePiece;
    private Random randomgenerator;

    public ComputerPlayer(String gamePiece) {
        this.gamePiece = gamePiece;
        randomgenerator = new Random();
    }

    public String getGamePiece() {
        return gamePiece;
    }

    public String chooseOpenSpace(List<String> openCells) {
        int index = randomgenerator.nextInt(openCells.size());
        String space = openCells.get(index);
        return space;
    }
}
