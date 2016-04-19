package array.medium;

public class FindMinimuminRotatedSortedArray {

	public int findMin(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}

		int start = 0, end = nums.length - 1;
		int target = nums[nums.length - 1];

		// find the first element <= target
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] <= target) {
				end = mid;
			} else {
				start = mid;
			}
		}
		if (nums[start] <= target) {
			return nums[start];
		} else {
			return nums[end];
		}
	}

	public static void main(String[] args) {
		// int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		// int[] nums = { 0, 1, 2, 4, 5, 6, 7 };
		int[] nums = { 2, 3, 4, 5, 1 };
		FindMinimuminRotatedSortedArray f = new FindMinimuminRotatedSortedArray();
		System.out.println(f.findMin(nums));
	}

}
