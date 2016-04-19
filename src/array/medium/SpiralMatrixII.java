package array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		if (n <= 0)
			return null;

		int[][] matrix = new int[n][n];
		int nSqr = n * n;
		int num = 1;

		int up = 0;
		int down = n - 1;
		int left = 0;
		int right = n - 1;

		while (num <= nSqr) {
			if (up == down) {
				for (int i = left; i <= right; i++) {
					matrix[up][i] = num++;
				}
				return matrix;
			}

			if (left == right) {
				for (int i = up; i <= down; i++) {
					matrix[i][left] = num++;
				}
				return matrix;
			}

			for (int i = left; i <= right; i++) {
				matrix[up][i] = num++;
			}
			up++;

			for (int i = up; i <= down; i++) {
				matrix[i][right] = num++;
			}
			right--;
			for (int i = right; i >= left; i--) {
				matrix[down][i] = num++;
			}
			down--;
			for (int i = down; i >= up; i--) {
				matrix[i][left] = num++;
			}
			left++;
		}
		return matrix;
	}
}
