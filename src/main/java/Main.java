package src.main.java;

import java.util.*;
import java.util.Scanner;

public class Main {

  public static void main(final String[] args) throws InterruptedException {

    int rounds = 0; // integer to count the number of rounds
    String player1 = "Player 1"; // String holding the name/username of player 1
    String player2 = "Player 2"; // String holding the name/username of player 2
    boolean game =
        true; // boolean tracking if the game is currently being played or not (used for looping)
    boolean p1_playing =
        true; // using a boolean to track which player's turn it is (player 1 = true, player 2 =
    // false)

    player1 = Main.getPlayerOne(player1); // sets player1 to the first players specified username
    player2 = Main.getPlayerTwo(player2); // sets player2 to the second players specified username

    UI ui = new UI(); // creates new UI object
    ui.createBoard(); // fills the board with blanks
    ui.printBoard(); // initially prints the board

    System.out.println("");
    System.out.println(player1 + ", you are Xs.");
    System.out.println(player2 + ", you are Os.");

    Main.takeInput(player1, player2, p1_playing);

  }

  private static String getPlayerOne(String player1) {
    Scanner sc = new Scanner(System.in); // opens scanner for user input
    int count = 0; // counts how many time user enters null username
    do {
      System.out.print("Player One, please enter your username: ");
      player1 = sc.nextLine(); // sets input to player1
      count++;
    } while (player1.isEmpty() && count < 3); // loops 3 times for user to enter a username

    if (!player1.isEmpty()) return player1; // sets username to given input
    else return "Player 1"; // sets username to default username
  }

  private static String getPlayerTwo(String player2) {
    Scanner sc = new Scanner(System.in); // opens scanner for user input
    int count = 0; // counts how many time user enters null username
    do {
      System.out.print("Player Two, please enter your username: ");
      player2 = sc.nextLine(); // sets input to player2
      count++;
    } while (player2.isEmpty() && count < 3); // loops 3 time for user to enter a username

    if (!player2.isEmpty()) return player2; // sets username to given input
    return "Player 2"; // sets username to default username
  }

  private static void takeInput(String player1, String player2, boolean p1_playing){
  	System.out.println("");
  	Scanner sc = new Scanner(System.in); // initializes the Scanner
  	String name;

  	if (p1_playing == true){
  		name = player1;
  	} else{
  		name = player2;
  	}

  	System.out.println(name + ", it is your turn.");
  	System.out.println("");
  	System.out.print("Choose a coordinate on the x axis: ");
  	int x = Integer.parseInt(sc.nextLine()); // sets x coordinate to player input
  	System.out.print("Choose a coordinate on the y axis: ");
  	int y = Integer.parseInt(sc.nextLine()); // sets y coordinate to player input

  	System.out.println("X: " + x + " / Y: " + y); // for testing purposes

  }

}
