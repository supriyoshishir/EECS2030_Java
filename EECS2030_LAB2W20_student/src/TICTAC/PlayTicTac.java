package TICTAC;

public class PlayTicTac {
	/**
	 * board a 3x3 array containing 0, 1, 2, values indicating blanks or player
	 * numbers
	 */
	private int[][] board;

	public PlayTicTac() {
		this.board = new int[3][3];
	}

	/**
	 * Checks if player has won tic-tac-toe along diagonal lines.
	 * 
	 * @param player
	 *            the player to check for a winning sequence of marks
	 * @return true if player won, false otherwise
	 */
	private boolean wonDiagonal(int player) {
		boolean Rmax = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == j && Rmax) {
					Rmax = (this.board[i][j] == player) ? true : false;
				}
			}
		}
		// other way
		boolean Rmin = true;
		for (int i = 3; i >= 0; i--) {
			for (int j = 3; j >= 0; j--) {
				if ((i + j) == (3 - 1) && Rmin) {
					Rmin = (this.board[i][j] == player) ? true : false;
				}
			}
		}
		return (Rmax || Rmin) ? true : false;

	}

	/**
	 * Checks if player has won tic-tac-toe along straight lines.
	 * 
	 * @param player
	 *            the player to check for a winning sequence of marks
	 * @return true if player won, false otherwise
	 */
	private boolean wonStraightLines(int player) {
		boolean result = true;
		int i = 0;
		do {
			for (int j = 0; j < 3; j++) {
				if (result) {
					result = (this.board[i][j] == player) ? true : false;
				}
			}
			if (!result) {
				result = true;
				for (int j = 0; j < 3; j++) {
					if (result) {
						result = (this.board[j][i] == player) ? true : false;
					}
				}
			}
			i++;
		} while (!result && i < 3);
		return result;
	}

	/**
	 * Checks if player has won.
	 * 
	 * @param player
	 *            the player to check for a winning sequence of marks
	 * @return true if player won, false otherwise
	 */
	public boolean win(int player) {
		return (this.wonDiagonal(player) || this.wonStraightLines(player)) ? true : false;
	}

	/**
	 * Draws gameboard, player 1 is X, player 2 is O.
	 */
	public void drawBoard() {
		System.out.println("|-----|");
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 1) {
					System.out.print("|X");
				} else if (board[i][j] == 2) {
					System.out.print("|O");
				} else {
					System.out.print("| ");
				}
			}
			System.out.println("|\n|-----|");
		}
	}

	/**
	 * Choose a cell for player has won.
	 * 
	 * @param r
	 *            the row number chose
	 * @param c
	 *            the column number chose
	 * @param player
	 *            the player who choose a position
	 * @throws ArrayOutOfBoundException
	 * @throws UnavailableCellException
	 *             is the cell has been occupied (by either player)
	 */

	public void choose(int r, int c, int player) throws ArrayOutOfBoundException, UnavailableCellException {
		if (r > 2 || c > 2) {
			throw new ArrayOutOfBoundException("Does not exist on the gameboard");
		} else if (this.board[r][c] == 0) {
			this.board[r][c] = player;
		} else {
			throw new UnavailableCellException("Already occupied");
		}

	}
}