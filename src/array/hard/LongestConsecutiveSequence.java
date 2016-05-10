package array.hard;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int maxLength = 1;

		Set<Integer> set = new HashSet<>();
		for (int n : nums)
			set.add(n);
		for (int i = 0; i < nums.length && set.size() > 0; i++) {
			int tempLength = 1;
			int temp = nums[i];
			set.remove(temp);
			while (set.contains(temp + 1)) {
				temp++;
				tempLength++;
				set.remove(temp);
			}
			temp = nums[i];
			while (set.contains(temp - 1)) {
				temp--;
				tempLength++;
				set.remove(temp);
			}
			maxLength = Math.max(maxLength, tempLength);
		}

		return maxLength;
	}
	
	public static void main(String[] args) {
		LongestConsecutiveSequence o = new LongestConsecutiveSequence();
		int[] nums = {100,4,200,3,1,2};
		System.out.println(o.longestConsecutive(nums));
	}
}
