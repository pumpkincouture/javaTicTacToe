package com.solak.TTT;

public class CreatePlayer {
    private CommandLineInterface ui;
    private Player player;

    public CreatePlayer(CommandLineInterface ui) {
        this.ui = ui;
    }

    public Object getChosenOpponent() {
        checkChoice(chooseOpponent());
        return getAssignedOpponent();
    }

    public Object getAssignedOpponent() {
        return player;
    }

    private String chooseOpponent() {
        ui.promptForOpponent();
        return ui.captureChoice();
    }

    private void checkChoice(String opponentChoice) {
        String capitalizedChoice = opponentChoice.toUpperCase();
        String computerChoice = "C";
        String humanChoice = "H";
        String invalidChoice = "i";

        if (capitalizedChoice.equals(computerChoice)) {
            player = new ComputerPlayer("O", new Board());
        } else if (capitalizedChoice.equals(humanChoice)) {
            player = new HumanPlayer("O", ui);
        } else {
            ui.printError(opponentChoice);
            checkChoice(chooseOpponent());
        }
    }
}

