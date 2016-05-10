package array.medium;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m = grid.length, n = grid[0].length;
		int[][] sum = new int[m][n];
		sum[0][0] = grid[0][0];
		for (int i = 1; i < m; i++)
			sum[i][0] = grid[i][0] + sum[i - 1][0];
		
		for (int j = 1; j < n; j++)
			sum[0][j] = grid[0][j] + sum[0][j - 1];

		for (int i = 1; i < m; i++)
			for (int j = 1; j < n; j++)
				sum[i][j] = Math.min(sum[i][j - 1], sum[i - 1][j]) + grid[i][j];

		return sum[m - 1][n - 1];
	}

	public static void main(String[] args) {
		MinimumPathSum o = new MinimumPathSum();
		int[][] grid = { { 1, 2 }, { 1, 1 } };
		System.out.println(o.minPathSum(grid));
	}
}
