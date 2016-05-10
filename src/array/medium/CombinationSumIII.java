package array.medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		helper(k, n, 1, list, result);
		return result;
	}

	private void helper(int k, int n, int tmp, List<Integer> list,
			List<List<Integer>> result) {
		if (k < 0 || n < 0)
			return;
		if (n == 0 && k == 0)
			result.add(new ArrayList<>(list));
		for (int i = tmp; i <= 9; i++) {
			list.add(i);
			helper(k - 1, n - i, i + 1, list, result);
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		CombinationSumIII c = new CombinationSumIII();
		List<List<Integer>> result = c.combinationSum3(3, 9);
		for (List<Integer> list : result)
			System.out.println(list);
	}
}
