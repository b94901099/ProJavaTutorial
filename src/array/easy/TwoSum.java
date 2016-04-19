package array.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				List<Integer> indexes = new ArrayList<Integer>();
				indexes.add(i);
				map.put(nums[i], indexes);
			} else {
				List<Integer> list = map.get(nums[i]);
				list.add(i);
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int tmpTarget = target - nums[i];
			if (map.containsKey(tmpTarget)) {
				List<Integer> indexes = map.get(tmpTarget);
				for (int j = 0; j < indexes.size(); j++) {
					if (indexes.get(j) != i) {
						int[] result = { i, indexes.get(j) };
						return result;
					}
				}
			}
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 2, 4 };
		int target = 6;
		int[] result = new TwoSum().twoSum(nums, target);
		System.out.println(result[0] + ", " + result[1]);
	}

}
