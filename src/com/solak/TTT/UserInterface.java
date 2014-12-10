package com.solak.TTT;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by administrator on 12/4/14.
 */

public class UserInterface {

    public void printWelcomeMessage() {
        System.out.println("Welcome to Tic Tac Toe!");
    }

    public void printGamePieceAssignment(String playerOnePiece, String playerTwoPiece) {
        System.out.println("Player 1 will have the " + playerOnePiece + " piece and Player 2 will have the " + playerTwoPiece + " piece.");
    }

    public void printRules() {
        System.out.println("The first player to get 3 in a row wins!");
    }

    public void printStartingPlayer(String gamePiece) {
        System.out.println("Player with " + gamePiece +  " will start.");
    }

    public String captureChoice() {
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        return choice;
    }

    public void printUserPrompt(String gamePiece) {
        System.out.println("Please choose a valid space with your " + gamePiece + ".");
    }

    public void printWinner(String gamePiece) {
        System.out.println(gamePiece + " wins!");
    }

    public void catsGame() {
        System.out.println("Cat's game!");
    }

    public void printGameOver() {
        System.out.println("The game is over.");
    }

    public void printError() {
        System.out.println("That move is not available, please try again.");
    }

    public void printBoard(HashMap<String, String> boardCells) {
        printTopRow(boardCells);
        printLines();
        printMiddleRow(boardCells);
        printLines();
        printBottomRow(boardCells);
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

