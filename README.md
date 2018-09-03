# Tic Tac Toe

## How to Run
### Gradle
First cd into the file tic-tac-toe. Then run `gradle build`.  If you recieve an error stating `Execution failed for task ':verifyGoogleJavaFormat'.`, run `gradle goJF`.

Then run `gradle run` to have the program run.

### Java
Run `java -classpath . src.main.java.Main` OR `java src.main.java.Main`.

## Functional Requirements
- Gather and display user names. Decide who makes the first move (assign the X mark).
- Display a proper board.
- Take turns letting the players move.
	- Detect and announce when one wins.
	- Prevent illegal moves.
	- Indicate a draw.
- When the game is over, give the same players a chance to play again.


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
	- (BOOL) Current player/symbol.
	- (BOOL) Game completed.
	- (INT) Game rounds. (?)