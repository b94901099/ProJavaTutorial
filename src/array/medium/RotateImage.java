package array.medium;

public class RotateImage {
	public void rotate(int[][] matrix) {
		if (matrix == null || matrix.length < 2 || matrix[0].length < 2) {
			return;
		}

		int down = 0, up = matrix.length - 1, left = 0, right = matrix[0].length - 1;
		while (down < up && left < right) {
			for (int i = left; i <= right; i++) {
				int tmp = matrix[down][i];
				matrix[down][i] = matrix[up - i][left];
				matrix[up - i][left] = matrix[up][right - i];
				matrix[up][right - i] = matrix[i][right];
				matrix[i][right] = tmp;
			}
			left++;
			right--;
			down++;
			up--;
		}
	}

	public void rotate2(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n / 2; i++) {
			int start = i;
			int end = n - 1 - i;

			for (int j = start; j < end; j++) {
				int offset = j - start;
				int temp = matrix[start][j];
				matrix[start][j] = matrix[end - offset][start];
				matrix[end - offset][start] = matrix[end][end - offset];
				matrix[end][end - offset] = matrix[j][end];
				matrix[j][end] = temp;
			}
		}
	}
}
