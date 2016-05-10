package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
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
			helper(res, tmp, cand, target - cand[i], i + 1);
			tmp.remove(tmp.size() - 1);
			while (i + 1 < cand.length && cand[i] == cand[i + 1])
				i++;
		}
	}

	public static void main(String[] args) {
		CombinationSumII o = new CombinationSumII();
		int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
		int target = 8;
		List<List<Integer>> result = o.combinationSum2(candidates, target);
		for (List<Integer> list : result) {
			for (Integer i : list)
				System.out.print(i + ",");
			System.out.println();
		}
	}
}
