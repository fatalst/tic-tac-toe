package src.main.java;

import java.util.*;

public class PlayerInfo {

  public static String getPlayerOne() {
    String player1;
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

  public static String getPlayerTwo() {
    String player2;
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
}
