package com.solak.TTT;

public class CreatePlayer {
    private CommandLineInterface ui;

    public CreatePlayer(CommandLineInterface ui) {
        this.ui = ui;
    }

    public String chooseOpponent() {
        ui.promptForOpponent();
        return ui.captureChoice();
    }

    public String validateChoice(String opponentChoice) {
        String capitalizedChoice = opponentChoice.toUpperCase();
        String computerChoice = "C";
        String humanChoice = "H";

        if (capitalizedChoice.equals(computerChoice)) {
            return computerChoice;
        } else if (capitalizedChoice.equals(humanChoice)) {
            return humanChoice;
        } else {
            ui.printError(opponentChoice);
        }
        return computerChoice;
    }


}

