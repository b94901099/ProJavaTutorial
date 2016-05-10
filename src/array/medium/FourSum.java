package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		Arrays.sort(nums);
		helper(res, tmp, nums, target, 0);
		return res;
	}

	private void helper(List<List<Integer>> res, List<Integer> tmp, int[] cand,
			int target, int pos) {
		if (tmp.size() > 4)
			return;
		if (target == 0 && tmp.size() == 4) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = pos; i < cand.length; i++) {
			tmp.add(cand[i]);
			helper(res, tmp, cand, target - cand[i], i + 1);
			tmp.remove(tmp.size() - 1);
			while (i + 1 < cand.length && cand[i] == cand[i + 1])
				i++;
		}
	}

	public static void main(String[] args) {
		FourSum o = new FourSum();
		int[] candidates = { 1, 0, -1, 0, -2, 2 };
		int target = 0;
		List<List<Integer>> result = o.fourSum(candidates, target);
		for (List<Integer> list : result) {
			for (Integer i : list)
				System.out.print(i + ",");
			System.out.println();
		}
	}

}
