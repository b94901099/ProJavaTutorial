package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return result;
		}

		Arrays.sort(nums);
		List<Integer> list = new ArrayList<>();

		helper(nums, 0, list, result);

		return result;
	}

	private void helper(int[] nums, int position, List<Integer> list,
			List<List<Integer>> result) {
		result.add(new ArrayList<>(list));

		for (int i = position; i < nums.length; i++) {
			if (i != position && nums[i - 1] == nums[i]) {
				continue;
			}
			list.add(nums[i]);
			helper(nums, i + 1, list, result);
			list.remove(list.size() - 1);

		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 2 };
		List<List<Integer>> result = new SubsetsII().subsetsWithDup(nums);
		System.out.println(result);
	}

}
