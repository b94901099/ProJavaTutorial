package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList();
		if (nums == null || nums.length < 3)
			return result;

		Arrays.sort(nums);
		int n = nums.length;

		for (int i = 0; i < n - 2; i++) {

			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			int j = i + 1;
			int k = n - 1;

			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == 0) {
					List<Integer> list = new ArrayList();
					list.add(nums[i]);
					list.add(nums[j]);
					list.add(nums[k]);
					result.add(list);
					do {
						j++;
					} while (j < k && nums[j] == nums[j - 1]);
					do {
						k--;
					} while (j < k && nums[k] == nums[k + 1]);
				} else if (sum > 0) {
					do {
						k--;
					} while (j < k && nums[k] == nums[k + 1]);
				} else {
					do {
						j++;
					} while (j < k && nums[j] == nums[j - 1]);
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		ThreeSum t = new ThreeSum();
		int[] nums = { -1, 0, 1, 2, -1, -4 };

		List<List<Integer>> result = t.threeSum(nums);

		for (List<Integer> list : result) {
			System.out.println(list);
		}
	}
}
