package com.solak.TTT;

public class SetUp {
    private Player player1;
    private Player player2;
    private Board board;
    private CommandLineInterface userinterface;

    public SetUp(){
        this.player1 = new Player("X");
        this.player2 = new Player("O");
        this.board = new Board();
        this.userinterface = new CommandLineInterface();
    }

    public Player getFirstPlayer() {
        return player1;
    }

    public Player getSecondPlayer() {
        return player2;
    }

    public Board getBoard() {
        return board;
    }

    public CommandLineInterface getUI() {
        return userinterface;
    }
}
