package array.easy;

public class RotateArray {

	public void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 1)
			return;

		int n = nums.length;
		k = k % n;
		int[] tmp = new int[k];
		for (int i = 0; i < k; i++)
			tmp[i] = nums[n - k + i];

		for (int i = n - k - 1; i >= 0; i--)
			nums[i + k] = nums[i];

		for (int i = 0; i < k; i++)
			nums[i] = tmp[i];
	}

	public void rotate2(int[] nums, int k) {
		if (nums.length == 0) {
			return;
		}

		k = k % nums.length;
		reverse(nums, 0, nums.length - k - 1);
		reverse(nums, nums.length - k, nums.length - 1);
		reverse(nums, 0, nums.length - 1);
	}

	private void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	public static void main(String[] args) {
		RotateArray r = new RotateArray();
		// int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int[] nums = { 1, 2 };
		r.rotate(nums, 3);
		for (int num : nums)
			System.out.print(num);
	}

}
