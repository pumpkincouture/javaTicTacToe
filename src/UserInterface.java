/**
 * Created by administrator on 12/4/14.
 */
import java.util.Scanner;

public class UserInterface {

    public void welcomeMessage(){
        System.out.println("Welcome to Tic Tac Toe.");
    }

    public void getPlayerName(){
        System.out.println("Please enter your name.");
    }

    public String captureChoice(){
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        return choice;
    }

    public void gamePieceAssignment(){
        System.out.println("Player 1 will have the X piece and Player 2 will have the O piece");
    }

    public void userPrompt(String gamePiece){
        System.out.println("Please place a move with your " + gamePiece);
    }

    public void printWinner(String playerName){
        System.out.println(playerName + " wins!");
    }

    public void catsGame(){
        System.out.println("Cat's game!");
    }

    public void printError(){
        System.out.println("That move is not available, please try again.");
    }
}
