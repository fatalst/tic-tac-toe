# Tic Tac Toe

## How to Run
### Gradle
First cd into the file tic-tac-toe. Then run `gradle build`.  If you recieve an error stating `Execution failed for task ':verifyGoogleJavaFormat'.`, run `gradle goJF`.

Then run `gradle run` to have the program run.

### Java
Compile the code with `javac src/main/java/Main.java`.
Run the code with `java src.main.java.Main`.

## Functional Requirements
- MANDATORY:
	- Gather and display user names. Decide who makes the first move (assign the X mark). (x)
	- Display a proper board. (x)
	- Take turns letting the players move. (x)
	- Detect and announce when one wins. (x)
		- Prevent illegal moves. (x)
		- Indicate a draw. (x)
- OPTIONAL:
	- When the game is over, give the same players a chance to play again. (x)
	- Track the players' scores across games.
	- Swap X and O between players every game.


## To Do
1. Create update function.
	- Updates UI to reflect new choice.
	- Changes player.
	- Changes symbol being written to grid.
2. Create UI.
	- Create grid.
	- Create/choose symbols for X and O.
3. Create print function.
	- Prints the UI to the screen.
4. Implement user input.
	- Allow user to input choice of where in the grid their symbol should go.
	- Checks for input that cannot be used/will cause an error and asks for new input.
	- Checks to see if there is a winner and updates variables as needed.
5. Create variables.
	- (STR) Player usernames x2.
	- (BOOL) Game completed.
	- (INT) Game rounds.