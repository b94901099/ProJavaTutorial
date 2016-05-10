package array.medium;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0) {
			return;
		}

		int i = nums.length - 1;

		while (i > 0 && nums[i - 1] >= nums[i])
			i--;

		if (i == 0) {
			reverseArray(nums, 0, nums.length - 1);
			return;
		}

		int toSwapIndex = i - 1;
		while (i < nums.length && nums[i] > nums[toSwapIndex])
			i++;

		swap(nums, toSwapIndex, i - 1);
		reverseArray(nums, toSwapIndex + 1, nums.length - 1);
	}

	private void swap(int[] num, int p, int q) {
		int tmp = num[p];
		num[p] = num[q];
		num[q] = tmp;
	}

	private void reverseArray(int[] num, int start, int end) {
		while (start < end) {
			int tmp = num[start];
			num[start] = num[end];
			num[end] = tmp;
			start++;
			end--;
		}
	}
}
