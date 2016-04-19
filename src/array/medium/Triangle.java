package array.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {

		if (triangle == null || triangle.size() == 0)
			return -1;

		Queue<Integer> sumQueue = new LinkedList<>();
		List<Integer> btm = triangle.get(triangle.size() - 1);
		for (Integer num : btm) {
			sumQueue.offer(num);
		}

		int sum1 = 0, sum2 = 0;
		for (int i = triangle.size() - 2; i >= 0; i--) {
			sum1 = sumQueue.poll();
			sum2 = 0;
			List<Integer> curLevel = triangle.get(i);
			for (int j = 0; j < curLevel.size(); j++) {
				sum2 = sumQueue.poll();
				int num = curLevel.get(j);
				sumQueue.offer(Math.min(num + sum1, num + sum2));
				sum1 = sum2;
			}
		}

		if (sumQueue.size() == 0)
			return sum1;

		return sumQueue.poll();
	}
}
