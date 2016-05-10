package array.hard;

import java.util.Stack;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		int ret = 0;

		if (heights == null) {
			return 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		int N = heights.length;
		for (int i = 0; i < N; ++i) {
			if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
				stack.push(i);
			} else {
				int index = stack.pop();
				int area = heights[index]
						* (stack.isEmpty() ? i : i - stack.peek() - 1);
				ret = Math.max(ret, area);
				--i;
			}
		}

		while (!stack.isEmpty()) {
			int index = stack.pop();
			int area = heights[index]
					* (stack.isEmpty() ? N : N - stack.peek() - 1);
			ret = Math.max(ret, area);
		}

		return ret;
	}

}
