package com.solak.TTT;

public class GameRunner {

    public static void main(String[] args) {
        Player player1 = new Player("X");
        Player player2 = new Player("O");
        Board board = new Board();
        UserInterface ui = new CommandLineInterface();
        Game game = new Game(player1, player2, board, (CommandLineInterface) ui);
        game.startGame();
    }
}
