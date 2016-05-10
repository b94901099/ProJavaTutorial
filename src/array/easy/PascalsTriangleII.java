package array.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PascalsTriangleII {

	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();

		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);

		for (int row = 1; row <= rowIndex; row++) {
			int n1 = queue.poll();
			queue.offer(1);
			for (int i = 0; i < row - 1; i++) {
				int n2 = queue.poll();
				queue.offer(n1 + n2);
				n1 = n2;
			}
			queue.offer(1);
		}

		while (queue.size() > 0) {
			list.add(queue.poll());
		}

		return list;
	}

	public static void main(String[] args) {
		PascalsTriangleII p = new PascalsTriangleII();
		System.out.println(p.getRow(1));
	}

}
