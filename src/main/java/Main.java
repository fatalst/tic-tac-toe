package src.main.java;

import java.util.*;
import java.util.Scanner;

public class Main {

  private static int rounds; // integer to count the number of rounds
  private static boolean
      game; // boolean tracking if the game is currently being played or not(used for looping)
  private static int numGames = 1;

  private static PlayerInfo pi = new PlayerInfo(); // creates new PI object
  public static String player1 = pi.getPlayerOne(); // holding player 1's username
  public static String player2 = pi.getPlayerTwo(); // holding player 2's username

  private static int p1Score = 0; // holding player 1's score
  private static int p2Score = 0; // holding player 2's score

  private static UI ui = new UI(); // creates new UI object

  public static void main(final String[] args) throws InterruptedException {
    Scanner sc = new Scanner(System.in); // opens scanner for user input
    Main.spaces();
    System.out.println(player1 + ", you are Xs.\n" + player2 + ", you are Os.");
    //Main.getPlayerInfo();
    Main.startGame();
    boolean validResponse;
    boolean rematch = true;

    do {
      game = true;
      do {
        char marker = ui.getPlayerMarker(); // keep track of whose turn

        int row = Main.getRow(player1, player2, marker);
        int col = Main.getCol(player1, player2, marker);
        System.out.println("");
        System.out.println(
            "Your coordinates are: " + row + ", " + col); // mostly for testing but could keep in

        validResponse =
            ui.placeMark(
                row,
                col); // returns if the response is valid or not; if valid, places mark on the board

        // checking if the input is out of bounds
        if (validResponse == false) {
          System.out.println("That is an invalid set of coordinates.  Please try again.");
          continue;
        }

        ui.printBoard(); // prints board with added mark for current update of game

        rounds++;

        // checks to see if there is a winner by calling checkEnding()
        if (rounds >= 5) {
          if (ui.checkEnding('X') == true) {
            System.out.println("");
            System.out.println(player1 + " wins!");
            p1Score++;
            game = false;
          } else if (ui.checkEnding('O')) {
            System.out.println("");
            System.out.println(player2 + " wins!");
            p2Score++;
            game = false;
          }
          // assuming wrong answers are impossible AND if someone wins, the game ends -- ends the
          // game on a draw.
        } else if (rounds == 9) {
          System.out.println("");
          System.out.println("Draw!");
          game = false;
        }

        ui.changePlayer(); // alternate turn and player mark
      } while (game == true);

      System.out.println("");
      System.out.println("Number of games played: " + numGames);

      System.out.println("");
      System.out.println(player1 + "'s score: " + p1Score);
      System.out.println(player2 + "'s score: " + p2Score);

      System.out.println("");
      System.out.println("Play again? (Y/N)");
      String response = sc.nextLine();

      // checking player input, seeing if they would like to rematch
      if (response.equalsIgnoreCase("Y")) {
        rematch = true;
        numGames++;
        ui.reset();
        Main.spaces();
        Main.startGame();
        if (p1Score >= p2Score) {
          ui.changePlayer(); // Let's player with lowest score start game
          // if tied score, winner of last game goes first
        }
      } else rematch = false;
    } while (rematch == true);
  }

  private static void startGame() {
    rounds = 0; // integer to count the number of rounds

    // start game
    ui.createBoard(); // fills the board with blanks
    ui.printBoard(); // initially prints the board
  }

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

  public static void spaces() {
  	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
  }
}
