package src.main.java;

import java.util.*;

public class UI {

  private char[][] gameBoard;

  public UI() {
    gameBoard = new char[3][3]; // declare 2d array gameBoard of size 3x3
  }

  public void createBoard() {
    for (int i = 0; i < 3; i++) { // loops through rows
      for (int j = 0; j < 3; j++) { // loops through columns
        gameBoard[i][j] = ' '; // fills board with blank spaces
      }
    }
  }

  public void printBoard() {
  	System.out.println("");
    System.out.println("-------------"); // creates top boarder
    for (int i = 0; i < 3; i++) {
      System.out.print("| "); // creates left boarder
      for (int j = 0; j < 3; j++) {
        System.out.print(
            gameBoard[i][j] + " | "); // creates boarders between columns + right boarder
      }
      System.out.println();
      System.out.println("-------------"); // creates boarders between rows + bottom boarder
    }
  }
}
