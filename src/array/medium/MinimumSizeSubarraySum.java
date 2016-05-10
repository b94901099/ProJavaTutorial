package array.medium;

public class MinimumSizeSubarraySum {

	public int minSubArrayLen(int s, int[] nums) {
		int minLength = Integer.MAX_VALUE;
		int sum = 0;
		int start = 0, end = 0;
		while (start <= end && end < nums.length) {
			sum += nums[end];
			if (sum < s) {
				end++;
			} else {
				do {
					sum -= nums[start++];
				} while (start <= end && sum > s);
				sum -= nums[end];
				int len = end - start + 2;
				minLength = Math.min(minLength, len);
			}
		}

		if (minLength == Integer.MAX_VALUE)
			return 0;
		return minLength;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum m = new MinimumSizeSubarraySum();
		// int[] nums = { 1, 2, 3, 4, 5 };
		// int s = 11;
		int[] nums = { 2, 3, 1, 2, 4, 3, 7 };
		int s = 7;
		System.out.println(m.minSubArrayLen(s, nums));
	}

}
