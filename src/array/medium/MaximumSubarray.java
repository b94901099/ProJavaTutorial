package array.medium;

public class MaximumSubarray {

	public int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;

		int max = Integer.MIN_VALUE;
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			max = Math.max(sum, max);
			sum = Math.max(0, sum);
		}

		return max;
	}

	public static void main(String[] args) {
		MaximumSubarray m = new MaximumSubarray();
		int[] nums = { -1 };
		// int[] nums = { 4, -1, 2, 1 };
		System.out.println(m.maxSubArray(nums));
	}
}
