package com.solak.TTT;

public class GameRunner {

    public static void main(String[] args) {
        UserInterface ui = new CommandLineInterface();
        CreatePlayer pickOpponent = new CreatePlayer((CommandLineInterface) ui);
        pickOpponent.getChosenOpponent();

        Game game = new Game(new Player("X"), (Player) pickOpponent.getAssignedOpponent(), new Board(), (CommandLineInterface) ui);
        game.startGame();
    }
}
