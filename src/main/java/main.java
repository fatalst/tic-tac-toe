package java;
import java.util.*;
import java.util.Scanner;

public class Main {

  public static void main(final String[] args) throws InterruptedException {

  	int rounds = 0; // integer to count the number of rounds
  	String player1 = "Player 1"; // String holding the name/username of player 1
  	String player2 = "Player 2"; // String holding the name/username of player 2
  	boolean game = true; // boolean tracking if the game is currently being played or not (used for looping)
  	boolean p1_playing = true; // using a boolean to track which player's turn it is (player 1 = true, player 2 = false)

	player1 = Main.getPlayerOne(player1); //sets player1 to the first players specified username
	player2 = Main.getPlayerTwo(player2); //sets player2 to the second players specified username
}
	private static String getPlayerOne(String player1){
		Scanner sc = new Scanner(System.in); //opens scanner for user input
		do{
			System.out.println("Player One, Please enter your username.");
			player1 = sc.nextLine(); //sets input to player1
		}while(player1.isEmpty()); //loops until user enters a username for player
		//could change to allow only a certain number of retry attempts before closing scanner and using
        //default name
		return player1;
	}

	private static String getPlayerTwo(String player2){
		Scanner sc = new Scanner(System.in); //opens scanner for user input
		do{
			System.out.println("Player Two, Please enter your username.");
			player2 = sc.nextLine(); //sets input to player2
		}while(player2.isEmpty()); //loops until user enters a username for player2
		//could change to allow only a certain number of retry attempts before closing scanner and using
        //default name
		return player2;
	}
}