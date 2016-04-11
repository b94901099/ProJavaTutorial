package array.medium;

public class WordSearch {

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0) {
			return false;
		}

		int totalRow = board.length;
		int totalCol = board[0].length;

		boolean[][] used = new boolean[totalRow][totalCol];

		for (int i = 0; i < used.length * used[0].length - 1; i++) {
			used[i / totalCol][i % totalCol] = false;
		}

		for (int i = 0; i < totalRow; i++) {
			for (int j = 0; j < totalCol; j++) {
				if (existHelper(board, word, used, i, j))
					return true;
			}
		}
		return false;
	}

	private boolean existHelper(char[][] board, String word, boolean[][] used,
			int i, int j) {
		if (word == null || word.length() == 0)
			return true;
		if (i >= board.length || i < 0 || j >= board[0].length || j < 0)
			return false;
		if (board[i][j] != word.charAt(0))
			return false;
		if (used[i][j])
			return false;
		used[i][j] = true;
		boolean b = existHelper(board, word.substring(1), used, i - 1, j)
				|| existHelper(board, word.substring(1), used, i + 1, j)
				|| existHelper(board, word.substring(1), used, i, j - 1)
				|| existHelper(board, word.substring(1), used, i, j + 1);
		used[i][j] = false;
		return b;
	}

	public static void main(String[] args) {
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' },
				{ 'A', 'D', 'E', 'E' } };
		WordSearch w = new WordSearch();

		System.out.println(w.exist(board, "ABCCED"));
		System.out.println(w.exist(board, "SEE"));
		System.out.println(w.exist(board, "ABCB"));

	}
}
