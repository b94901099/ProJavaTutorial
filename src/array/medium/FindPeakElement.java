package array.medium;

public class FindPeakElement {
	public int findPeakElement(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > get(nums, i + 1) && nums[i] > get(nums, i - 1)) {
				return i;
			}
		}
		return 0;
	}

	private int get(int[] nums, int i) {
		if (i == -1 || i == nums.length) {
			return Integer.MIN_VALUE;
		}
		return nums[i];
	}
}
