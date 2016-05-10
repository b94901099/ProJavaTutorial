package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(candidates);
		helper(res, tmp, candidates, target, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> tmp, int[] cand,
			int target, int pos) {
		if (target < 0)
			return;
		if (target == 0) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = pos; i < cand.length; i++) {
			if (target < cand[i])
				break;
			tmp.add(cand[i]);
			helper(res, tmp, cand, target - cand[i], i);
			tmp.remove(tmp.size() - 1);
		}
	}
}
