package array.hard;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
	int maximalRectangle1(char[][] matrix) {
		if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
			return 0;
		}
		int[] height = new int[matrix[0].length];
		int max_area = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}
			max_area = Math.max(max_area, largestRectangleArea(height));
		}
		return max_area;
	}

	public int largestRectangleArea(int[] height) {
		int ret = 0;

		if (height == null) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int N = height.length;
		for (int i = 0; i < N; ++i) {
			if (stack.isEmpty() || height[stack.peek()] <= height[i]) {
				stack.push(i);
			} else {
				int index = stack.pop();
				int area = height[index]
						* (stack.isEmpty() ? i : i - stack.peek() - 1);
				ret = Math.max(ret, area);
				--i;
			}
		}

		while (!stack.isEmpty()) {
			int index = stack.pop();
			int area = height[index]
					* (stack.isEmpty() ? N : N - stack.peek() - 1);
			ret = Math.max(ret, area);
		}

		return ret;
	}

	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if (m == 0)
			return 0;
		int n = matrix[0].length;
		if (n == 0)
			return 0;

		int maxArea = 0;
		int[] height = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		Arrays.fill(right, n);
		for (int i = 0; i < m; i++) {
			// height[j] is the continuous 1's height above matrix[i][j]
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					height[j]++;
				} else {
					height[j] = 0;
				}
			}

			// left[j] is the leftest position where continuous 1 (with
			// height[j]) begins until matrix[i][j]
			int curLeft = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					left[j] = Math.max(curLeft, left[j]);
				} else {
					left[j] = 0;
					curLeft = j + 1;
				}
			}

			// right[j] is the rightest position where continuous 1 (with
			// height[j]) ends from matrix[i][j]
			int curRight = n;
			for (int j = n - 1; j >= 0; j--) {
				if (matrix[i][j] == '1') {
					right[j] = Math.min(curRight, right[j]);
				} else {
					right[j] = n;
					curRight = j;
				}
			}

			// comput area for every matrix[i][j], height is height[j], width is
			// right[j] - left[j]
			for (int j = 0; j < n; j++) {
				maxArea = Math.max(maxArea, (right[j] - left[j]) * height[j]);
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		MaximalRectangle m = new MaximalRectangle();
		char[][] matrix = { { '1', '0', '1', '1' }, { '0', '1', '1', '0' },
				{ '0', '1', '1', '0' }, { '0', '0', '0', '0' },
				{ '0', '1', '0', '1' } };
		System.out.println(m.maximalRectangle1(matrix));
	}
}
