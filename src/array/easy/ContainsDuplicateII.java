package array.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		if (nums == null || nums.length < 2 || k == 0) {
			return false;
		}

		Map<Integer, Integer> map = new HashMap();

		for (int i = 0; i < nums.length; i++) {
			int key = nums[i];
			if (!map.containsKey(key)) {
				map.put(key, i);
			} else {
				if (i - map.get(nums[i]) <= k)
					return true;
				map.put(nums[i], i);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateII c = new ContainsDuplicateII();
		int[][] numSet = { { 1, 2, 3, 4, 5, 1 }, { 1, 2 }, { 1 }, { 1, 2, 3 } };
		for (int[] nums : numSet) {
			System.out.println(c.containsNearbyDuplicate(nums, 5));
		}
	}

}
