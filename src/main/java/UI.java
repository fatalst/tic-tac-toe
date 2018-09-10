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

	public void reset() {
		currentPlayerMark = 'X'; // makes player1 X
	}

	public void createBoard() {
		for (int i = 2; i >= 0; i--) { // loops through rows
			for (int j = 0; j < 3; j++) { // loops through columns
				gameBoard[i][j] = ' '; // fills board with blank spaces
			}
		}
	}

	// added visual coordinates to make things easier for user input.
	public void printBoard() {
		int num = 2;
		System.out.println("");
		System.out.println(
			". 0 . . 1 . . 2"); // adding coordinates to the top. '.'s are placeholders for whitespace.
		System.out.println(". -------------"); // creates top boarder
		for (int i = 2; i >= 0; i--) {
			System.out.print(num + " | "); // creates left boarder
			num--; // adding coordinates to the side
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

	// checking for a winner
	public boolean checkEnding(char mark) {

		// checking evey possible win state for the game
		if(gameBoard[0][0] == mark && gameBoard[0][1] == mark && gameBoard[0][2] == mark) {
			//checking top row
			return true;
		} else if(gameBoard[1][0] == mark && gameBoard[1][1] == mark && gameBoard[1][2] == mark) {
			// checking middle row
			return true;
		} else if(gameBoard[2][0] == mark && gameBoard[2][1] == mark && gameBoard[2][2] == mark) {
			// checking bottom row
			return true;
		} else if(gameBoard[0][0] == mark && gameBoard[1][0] == mark && gameBoard[2][0] == mark) {
			// checking first column
			return true;
		} else if(gameBoard[0][1] == mark && gameBoard[1][1] == mark && gameBoard[2][1] == mark) {
			// checking middle column
			return true;
		} else if(gameBoard[0][2] == mark && gameBoard[1][2] == mark && gameBoard[2][2] == mark) {
			// checking last column
			return true;
		} else if(gameBoard[2][0] == mark && gameBoard[1][1] == mark && gameBoard[0][2] == mark) {
			// checking left to right diagonal
			return true;
		} else if(gameBoard[2][2] == mark && gameBoard[1][1] == mark && gameBoard[0][0] == mark) {
			// checking right to left diagonal
			return true;
		} else {
			// returns false if no one has won
			return false;
		}

	}

	public int winnerPlayer(int xCount, int oCount) {
		if(xCount == 3) {
			return 1; // return that player 1 has won
		} else if(oCount == 3) {
			return 2; // return that player 2 has won
		} else {
			return 0;
		}
	}

}
