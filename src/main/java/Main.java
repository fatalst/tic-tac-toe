package src.main.java;

import java.util.*;
import java.util.Scanner;

public class Main {

  private static int rounds; // integer to count the number of rounds
  private static boolean game; // boolean tracking if the game is currently being played or not (used for looping)
  private static boolean p1_playing; // using a boolean to track which player's turn it is (player 1 = true, player 2 =
	// false)

  private static String player1;
  private static String player2;
  private static UI ui = new UI(); // creates new UI object

  public static void main(final String[] args) throws InterruptedException {
	Scanner sc = new Scanner(System.in); // opens scanner for user input

	Main.startGame();

	boolean validResponse;

	do {
	  char marker = ui.getPlayerMarker(); // keep track of whose turn

	  int row =
		  Main.getRow(player1, player2, marker); // it puts row 0 at the top, instead of bottom
	  // like an actually coord plane... i'll fix that later
	  int col = Main.getCol(player1, player2, marker);
	  System.out.println(
		  "Your coordinates are: " + row + ", " + col); // mostly for testing but could keep in

	  validResponse = ui.placeMark(row, col); // returns if the response is valid or not; if valid, places mark on the board
	  
	  // checking if the input is out of bounds
	  if(validResponse == false){
		System.out.println("That is an invalid set of coordinates.  Please try again.");
		continue;
	  }
	  
	  ui.printBoard(); // prints board with added mark for current update of game

	  rounds++;

	  // TODO check for winner, if winner game == false to quit game
	  String winner = "";
	  if (ui.checkEnding() > 0){
		game = false;
		if (ui.checkEnding() == 1){
			System.out.println(player1 + " wins!");
		} else{
			System.out.println(player2 + " wins!");
		}
	  } 

	  // assuming wrong answers are impossible AND if someone wins, the game ends -- ends the game on a draw.
	  if(rounds == 9){
		System.out.println("");
		System.out.println("Draw!");
		game = false;
	  }

	  ui.changePlayer(); // alternate turn and player mark
	} while (game == true);
	
	// TODO: option for rematch -> started, doesn't seem to work at the moment.
	
	System.out.println("Play again? (Y/N)");
	String response = sc.nextLine();
	if(response == "Y" || response == "y"){
		ui.reset();
		Main.startGame();
	} 

  }

  private static void startGame(){
	rounds = 0; // integer to count the number of rounds

	// player information
	player1 = "Player 1"; // String holding the name/username of player 1
	player1 = Main.getPlayerOne(player1); // sets player1 to the first players specified username
	player2 = "Player 2"; // String holding the name/username of player 2
	player2 = Main.getPlayerTwo(player2); // sets player2 to the second players specified username
	game =
		true; // boolean tracking if the game is currently being played or not (used for looping)
	p1_playing =
		true; // using a boolean to track which player's turn it is (player 1 = true, player 2 =
	// false)
	System.out.println("");
	System.out.println(player1 + ", you are Xs.");
	System.out.println(player2 + ", you are Os.");

	// Main.takeInput(player1, player2, p1_playing);

	
	// start game
	ui.createBoard(); // fills the board with blanks
	ui.printBoard(); // initially prints the board
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

  /*
  public static void takeInput(String player1, String player2, boolean p1_playing) {
    System.out.println("");
    Scanner sc = new Scanner(System.in); // initializes the Scanner
    String name;

    if (p1_playing == true) {
      name = player1;
    } else {
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

  /*
  I split up gewtting the row and col coordinates so we could use the return values in the main
  method I couldn't figure out ho to do it from the takeInput method. Feel free to deletes these
  if you know how/ had something else in mind
    */
  public static int getRow(String player1, String player2, char marker) {
	System.out.println("");
	Scanner sc = new Scanner(System.in);
	String name;
	if (marker == 'X') {
	  name = player1;
	} else {
	  name = player2;
	}
	System.out.println(name + ", it is your turn.\n");
	System.out.print("Choose a coordinate on the x axis: \n");
	int row = Integer.parseInt(sc.nextLine()); // sets x coordinate to player input

	return row;
  }

  public static int getCol(String player1, String player2, char marker) {
	Scanner sc = new Scanner(System.in);
	System.out.println("");
	System.out.print("Choose a coordinate on the y axis: \n");
	int col = Integer.parseInt(sc.nextLine()); // sets y coordinate to player input

	return col;
  }

  public static boolean rematch() {
    boolean rematch = true;
    System.out.println("");
    System.out.println("Would you like to play again? Enter Y or N\n");
    Scanner sc = new Scanner(System.in);
    if (sc.next().equalsIgnoreCase("Y")) {
      rematch = true;
    } else rematch = false;

    return rematch;
  }
}
