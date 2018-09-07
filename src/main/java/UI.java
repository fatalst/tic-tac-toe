package src.main.java;

import java.util.*;

public class UI {

  private char[][] gameBoard;
  private char currentPlayerMark;

  public UI() {
    gameBoard = new char[3][3]; // declare 2d array gameBoard of size 3x3
    currentPlayerMark = 'X'; // makes player1 X
    createBoard();
  }

  public void createBoard() {
    for (int i = 0; i < 3; i++) { // loops through rows
      for (int j = 0; j < 3; j++) { // loops through columns
        gameBoard[i][j] = ' '; // fills board with blank spaces
      }
    }
  }

  // added visual coordinates to make things easier for user input.
  public void printBoard() {
    int num = 0;
    System.out.println("");
    System.out.println(". 0 . . 1 . . 2"); // adding coordinates to the top. '.'s are placeholders for whitespace.
    System.out.println(". -------------"); // creates top boarder
    for (int i = 0; i < 3; i++) {
      System.out.print(num + " | "); // creates left boarder
      num++; // adding coordinates to the side
      for (int j = 0; j < 3; j++) {
        // creates boarders between columns + right boarder
        System.out.print(gameBoard[i][j] + " | ");
      }
      System.out.println();
      System.out.println(". -------------"); // creates boarders between rows + bottom boarder
    }
  }

  public void changePlayer() {
    // changes to currentPlayerMark after every turn
    if (currentPlayerMark == 'X') {
      currentPlayerMark = 'O';
    } else {
      currentPlayerMark = 'X';
    }
  }

  public char getPlayerMarker() {
    // to help keep track of whose turn it is, gets CurrentPlayerMark w/o changing anything
    char marker = ' ';
    if (currentPlayerMark == 'X') {
      marker = 'X';
    } else {
      marker = 'O';
    }
    return marker;
  }

  public boolean placeMark(int row, int col) {
    // places the playing marks in their desired coordinates
    // could implement another try is row/col is out of bounds or spot is taken
    if ((row >= 0) && (row < 3)) { // checks to make sure row number entered is in ranged
      if ((col >= 0) && (col < 3)) { // checks to make sure col number entered is in ranged
        if (gameBoard[row][col] == ' ') { // check to make sure spot is open
          gameBoard[row][col] = currentPlayerMark; // sets mark to coordinate location
          return true;
        }
      }
    }
    return false;
  }

  // checking the endings.  not tested yet.


  /*public int checkEnding(){
    // checks to see if there is a draw
    if(ui.checkWinner()){
      return true;
    }
    int counter = 0;
    for (int i = 0; i < 3; i++) { // loops through rows
      for (int j = 0; j < 3; j++) { // loops through columns
        if(counter == 9){
          return true;
        }else if(gameBoard[i][j] == ' '){
          counter++;
        }
      }
    }
    return false;
  }

  // very much in progress

  public boolean checkWinner(){
    ArrayList<Character> board = new ArrayList<>();
    for (int i = 0; i < 3; i++) { // loops through rows
      for (int j = 0; j < 3; j++) { // loops through columns
        if(gameBoard[i][j] == 'X'){
          board.add('X');
        } else if(gameBoard[i][j] == 'O'){
          board.add('O');
        }
      }
    }
    int xCount = 0;
    int oCount = 0;
    for(int k = 0; k < board.size(); k++){
      if(xCount > )
      if(k <= 3){

      }
      if(board.get(k) == 'X'){
        xCount++;
      } else{
        oCount++;
      }
    }
  } */

}
