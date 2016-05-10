package array.medium;

public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length;
		int start = 0, end = m * n - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			System.out.println(String.format(
					"start = %d; end = %d; mid = %d; element = %d", start, end,
					mid, matrix[mid / n][mid % n]));
			if (matrix[mid / n][mid % n] == target)
				return true;
			if (matrix[mid / n][mid % n] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}

		if (matrix[start / n][start % n] == target
				|| matrix[end / n][end % n] == target)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Searcha2DMatrix o = new Searcha2DMatrix();
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 },
				{ 23, 30, 40, 50 } };
		int target = 3;
		System.out.println(o.searchMatrix(matrix, target));
	}
}
