package com.solak.TTT;

import java.util.HashMap;
import java.util.Scanner;

public class CommandLineInterface implements UserInterface {

    public void printWelcomeMessage() {
        System.out.println("Welcome to Tic Tac Toe! The first player to get 3 in a row wins!");
    }

    public void printChosenOpponent(String opponentName) {
        System.out.println("You've chosen to play against " + opponentName + ".");
    }

    public void printGamePieceAssignment(String playerOnePiece, String opponentName, String playerTwoPiece) {
        System.out.println("Player 1 will have the " + playerOnePiece + " piece and " + opponentName + " will have the " + playerTwoPiece + " piece.");
    }

    public void printStartingPlayer(String gamePiece) {
        System.out.println("Player with " + gamePiece +  " will start.");
    }

    public String captureChoice() {
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        return choice;
    }

    public void promptForOpponent() {
        System.out.println("Please choose your opponent : press 'h' for human or 'c' for computer.");
    }

    public void printUserPrompt(String playerName, String gamePiece) {
        System.out.println(playerName + ", please choose a move for your "  + gamePiece + " by pressing a number for that corresponding space.");
    }

    public void printWinner(String gamePiece) {
        System.out.println(gamePiece + " wins!");
    }

    public void printCatsGame() {
        System.out.println("Cat's game!");
    }

    public void printError(String choice) {
        System.out.println(choice + " is not available, please try again.");
    }

    public void printBoard(HashMap<String, String> boardCells) {
        printTopRow(boardCells);
        printLines();
        printMiddleRow(boardCells);
        printLines();
        printBottomRow(boardCells);
        System.out.print("\n");
    }

    private void printTopRow(HashMap<String, String> boardCells) {
        System.out.print(boardCells.get("1") + " | ");
        System.out.print(boardCells.get("2") + " | ");
        System.out.print(boardCells.get("3"));
    }

    private void printMiddleRow(HashMap<String, String> boardCells) {
        System.out.print(boardCells.get("4") + " | ");
        System.out.print(boardCells.get("5") + " | ");
        System.out.print(boardCells.get("6"));
    }

    private void printBottomRow(HashMap<String, String> boardCells) {
        System.out.print(boardCells.get("7") + " | ");
        System.out.print(boardCells.get("8") + " | ");
        System.out.print(boardCells.get("9"));
    }

    private void printLines() {
        System.out.print("\n");
        System.out.print("-------");
        System.out.print("\n");
    }
}


