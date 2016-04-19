package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

		public List<List<Integer>> subsets(int[] nums) {
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
				list.add(nums[i]);
				helper(nums, i + 1, list, result);
				list.remove(list.size() - 1);
	
			}
	
		}
	
		public static void main(String[] args) {
			int[] nums = { 1, 2, 3 };
			List<List<Integer>> result = new Subsets().subsets(nums);
			System.out.println(result);
		}

}
