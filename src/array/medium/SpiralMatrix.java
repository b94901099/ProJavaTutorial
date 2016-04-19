package array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		if (matrix == null) {
			return null;
		}
		ArrayList<Integer> list = new ArrayList();
		if (matrix.length == 0 || matrix[0].length == 0) {
			return list;
		}

		int up = 0;
		int down = matrix.length - 1;
		int left = 0;
		int right = matrix[0].length - 1;

		while (up <= down && left <= right) {
			if (up == down) {
				for (int i = left; i <= right; i++) {
					list.add(matrix[up][i]);
				}
				return list;
			}

			if (right == left) {
				for (int i = up; i <= down; i++) {
					list.add(matrix[i][right]);
				}
				return list;
			}
			for (int i = left; i <= right; i++) {
				list.add(matrix[up][i]);
			}
			up++;
			for (int i = up; i <= down; i++) {
				list.add(matrix[i][right]);
			}
			right--;
			for (int i = right; i >= left; i--) {
				list.add(matrix[down][i]);
			}
			down--;
			for (int i = down; i >= up; i--) {
				list.add(matrix[i][left]);
			}
			left++;
		}
		return list;
	}
}
