package array.medium;

public class GameOfLife {

	// In-place solution
	// dead->dead: 0;
	// live->live: 1;
	// dead->live: 2;
	// live->dead: 3;
	public void gameOfLife(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				int live = countNeighbors(board, i, j);
				if (board[i][j] == 1 && (live < 2 || live > 3))
					board[i][j] = 3;
				if (board[i][j] == 0 && live == 3)
					board[i][j] = 2;
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == 2) {
					board[i][j] = 1;
					continue;
				}
				if (board[i][j] == 3) {
					board[i][j] = 0;
					continue;
				}
			}
		}
	}

	public int countNeighbors(int[][] board, int row, int col) {
		int count = 0, rowN = board.length, colN = board[0].length;
		if (row > 0 && (board[row - 1][col] == 1 || board[row - 1][col] == 3))
			count++;
		if (row < rowN - 1
				&& (board[row + 1][col] == 1 || board[row + 1][col] == 3))
			count++;
		if (col > 0 && (board[row][col - 1] == 1 || board[row][col - 1] == 3))
			count++;
		if (col < colN - 1
				&& (board[row][col + 1] == 1 || board[row][col + 1] == 3))
			count++;
		if (row > 0
				&& col > 0
				&& (board[row - 1][col - 1] == 1 || board[row - 1][col - 1] == 3))
			count++;
		if (row < rowN - 1
				&& col < colN - 1
				&& (board[row + 1][col + 1] == 1 || board[row + 1][col + 1] == 3))
			count++;
		if (row > 0
				&& col < colN - 1
				&& (board[row - 1][col + 1] == 1 || board[row - 1][col + 1] == 3))
			count++;
		if (row < rowN - 1
				&& col > 0
				&& (board[row + 1][col - 1] == 1 || board[row + 1][col - 1] == 3))
			count++;
		return count;
	}

	public void gameOfLife2(int[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return;

		int m = board.length, n = board[0].length;
		int[][] originalBoard = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				originalBoard[i][j] = board[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveNeighborCount = countLiveNeighbor(originalBoard, i, j);
				if (isLive(originalBoard, i, j)) {
					if (liveNeighborCount == 2 || liveNeighborCount == 3)
						board[i][j] = 1;
					else
						board[i][j] = 0;
				} else {
					if (liveNeighborCount == 3)
						board[i][j] = 1;
					else
						board[i][j] = 0;
				}
			}
		}

	}

	private int countLiveNeighbor(int[][] board, int i, int j) {
		int count = 0;
		if (isLive(board, i - 1, j - 1))
			count++;
		if (isLive(board, i - 1, j))
			count++;
		if (isLive(board, i - 1, j + 1))
			count++;
		if (isLive(board, i, j - 1))
			count++;
		if (isLive(board, i, j + 1))
			count++;
		if (isLive(board, i + 1, j - 1))
			count++;
		if (isLive(board, i + 1, j))
			count++;
		if (isLive(board, i + 1, j + 1))
			count++;
		return count;
	}

	private boolean isLive(int[][] board, int i, int j) {
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
			return false;
		if (board[i][j] == 1)
			return true;
		return false;
	}

}
