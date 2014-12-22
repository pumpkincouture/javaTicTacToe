package com.solak.TTT;

public class HumanPlayer extends Player {
    private CommandLineInterface ui;

    public HumanPlayer(String gamePiece, CommandLineInterface ui) {
        super(gamePiece);
        this.ui = ui;
    }
    @Override
    public String getMove() {
       return ui.captureChoice();
    }
}
