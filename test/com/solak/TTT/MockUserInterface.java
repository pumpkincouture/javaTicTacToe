package com.solak.TTT;

import java.util.LinkedList;
import java.util.List;

public class MockUserInterface extends CommandLineInterface implements UserInterface {

    private List<String> nextMoves = new LinkedList<String>();
    private boolean displayInvalidMoveMessageCalled = false;

    public MockUserInterface() {
        nextMoves.add("5");

    }

    public void printWelcomeMessage() {

    }

    public void seeAllMoves() {
        System.out.println(nextMoves);
    }

    // ["1", "2", "4", "3", "7"] - player 1 wins
    // ["fpoksdfpoksdf", "1"] - invalid move, then valid move

    public void addNextMove(String move) {
        nextMoves.add(move);
        System.out.println(nextMoves);
    }

    public void getMovesList() {
        System.out.println(nextMoves);
    }

    public String captureChoice() {
        return nextMoves.remove(0);
    }

    public void displayInvalidMoveMessage() {
        displayInvalidMoveMessageCalled = true;
    }

    public boolean isDisplayInvalidMoveMessageCalled() {
        return displayInvalidMoveMessageCalled;
    }
}