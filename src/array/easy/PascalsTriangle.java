package array.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList();
		if (numRows <= 0)
			return triangle;
		List<Integer> base1 = new ArrayList();
		base1.add(1);
		triangle.add(base1);
		if (numRows == 1)
			return triangle;
		List<Integer> base2 = new ArrayList();
		base2.add(1);
		base2.add(1);
		triangle.add(base2);
		if (numRows == 2)
			return triangle;

		for (int i = 2; i < numRows; i++) {
			List<Integer> base = triangle.get(i - 1);
			List<Integer> newLayer = new ArrayList();
			newLayer.add(1);
			for (int j = 0; j < base.size() - 1; j++) {
				newLayer.add(base.get(j) + base.get(j + 1));
			}
			newLayer.add(1);
			triangle.add(newLayer);
		}

		return triangle;
	}

	public static void main(String[] args) {
		PascalsTriangle p = new PascalsTriangle();
		int numRows = 5;
		List<List<Integer>> triangle = p.generate(numRows);
		for (List<Integer> list : triangle) {
			for (Integer i : list) {
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
