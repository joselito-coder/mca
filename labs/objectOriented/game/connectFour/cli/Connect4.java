import java.util.Scanner;

public class Connect4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[][] connectFourGrid = new char[6][7];

		// initialize the connect four connectFourGrid
		for (int row = 0; row < connectFourGrid.length; row++) {
			for (int col = 0; col < connectFourGrid[0].length; col++) {
				connectFourGrid[row][col] = ' ';
			}
		}

		int turn = 1;
		char player = 'X';
		boolean winner = false;

		// play a turn
		while (winner == false && turn <= 42) {
			boolean validPlay;
			int col;
			do {
				displayConnectFourGrid(connectFourGrid);

				System.out.print("Player " + player + ", choose a column: ");
				col = sc.nextInt();

				if (col == 8) {
					validPlay = false;
					continue;
				}

				col = col - 1;

				// check if the move is valid or not
				validPlay = validate(col, connectFourGrid);

			} while (validPlay == false);

			// drop the checker
			for (int row = connectFourGrid.length - 1; row >= 0; row--) {
				if (connectFourGrid[row][col] == ' ') {
					connectFourGrid[row][col] = player;
					break;
				}
			}

			// check if any player is winning the game or not
			winner = isWinner(player, connectFourGrid);

			// switch colors to be placed on the grid
			if (player == 'X') {
				player = 'O';
			} else {
				player = 'X';
			}

			turn++;
		}
		displayConnectFourGrid(connectFourGrid);

		if (winner) {
			if (player == 'X') {
				System.out.printf("Player won\n");
			} else {
				System.out.printf("Red won\n");
			}
		} else {
			System.out.println("Tie game");
		}

	}

	public static void displayConnectFourGrid(char[][] connectFourGrid) {
		System.out.println(" 1 2 3 4 5 6 7");
		System.out.println("---------------");
		for (int row = 0; row < connectFourGrid.length; row++) {
			System.out.print("|");
			for (int col = 0; col < connectFourGrid[0].length; col++) {
				System.out.print(connectFourGrid[row][col]);
				System.out.print("|");
			}
			System.out.println();
			// System.out.println("---------------");
			// System.out.println();
		}
		System.out.println(" 1 2 3 4 5 6 7");
		System.out.println();
	}

	public static boolean validate(int column, char[][] connectFourGrid) {
		// valid if the column is valid move
		if (column < 0 || column > connectFourGrid[0].length) {
			return false;
		}

		// check if the whole column is not empty
		if (connectFourGrid[0][column] != ' ') {
			return false;
		}

		return true;
	}

	public static boolean isWinner(char player, char[][] connectFourGrid) {
		// check the row if any 4 dots connect
		for (int row = 0; row < connectFourGrid.length; row++) {
			for (int col = 0; col < connectFourGrid[0].length - 3; col++) {
				if (connectFourGrid[row][col] == player &&
						connectFourGrid[row][col + 1] == player &&
						connectFourGrid[row][col + 2] == player &&
						connectFourGrid[row][col + 3] == player) {
					return true;
				}
			}
		}

		// check for up and down if any dots connect
		for (int row = 0; row < connectFourGrid.length - 3; row++) {
			for (int col = 0; col < connectFourGrid[0].length; col++) {
				if (connectFourGrid[row][col] == player &&
						connectFourGrid[row + 1][col] == player &&
						connectFourGrid[row + 2][col] == player &&
						connectFourGrid[row + 3][col] == player) {
					return true;
				}
			}
		}

		// check the upward diagonal direction
		for (int row = 3; row < connectFourGrid.length; row++) {
			for (int col = 0; col < connectFourGrid[0].length - 3; col++) {
				if (connectFourGrid[row][col] == player &&
						connectFourGrid[row - 1][col + 1] == player &&
						connectFourGrid[row - 2][col + 2] == player &&
						connectFourGrid[row - 3][col + 3] == player) {
					return true;
				}
			}
		}

		// check the downward diagonal direction
		for (int row = 0; row < connectFourGrid.length - 3; row++) {
			for (int col = 0; col < connectFourGrid[0].length - 3; col++) {
				if (connectFourGrid[row][col] == player &&
						connectFourGrid[row + 1][col + 1] == player &&
						connectFourGrid[row + 2][col + 2] == player &&
						connectFourGrid[row + 3][col + 3] == player) {
					return true;
				}
			}
		}
		return false;
	}
}