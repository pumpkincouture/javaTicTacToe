package com.solak.TTT;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by administrator on 12/17/14.
 */
public class MockUserInterface implements UserInterface {

    private List<String> nextMoves = new LinkedList<String>();
    private boolean displayInvalidMoveMessageCalled = false;

    public void printWelcomeMessage() {

    }

    // ["1", "2", "4", "3", "7"] - player 1 wins
    // ["fpoksdfpoksdf", "1"] - invalid move, then valid move

    public void addNextMove(String move) {
        nextMoves.add(move);
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
