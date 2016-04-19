package array.medium;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

	public List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return result;

		int start = 0, end = 0;
		while (end < nums.length) {
			if (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
				end++;
			} else {
				if (start == end) {
					String s = Integer.toString(nums[start]);
					result.add(s);
				} else {
					String s = Integer.toString(nums[start]) + "->"
							+ Integer.toString(nums[end]);
					result.add(s);
				}
				start = end + 1;
				end++;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		SummaryRanges s = new SummaryRanges();
		// int[] nums = { 0, 1, 2, 4, 5, 7 };
		int[] nums = { 0};

		List<String> result = s.summaryRanges(nums);
		System.out.println(result);
	}

}
