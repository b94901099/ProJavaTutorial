package array.hard;

public class SearchinRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums[0] == target) {
			return 0;
		}
		if (nums[nums.length - 1] == target) {
			return nums.length - 1;
		}

		int start = 0;
		int end = nums.length - 1;
		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			}
			if (nums[mid] > nums[start]) {
				if (nums[start] <= target && target < nums[mid]) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			} else if (nums[mid] < nums[start]) {
				if (nums[mid] < target && target <= nums[end]) {
					start = mid + 1;
				} else {
					end = mid - 1;
				}
			}
		}
		if (nums[start] == target) {
			return start;
		}
		if (nums[end] == target) {
			return end;
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchinRotatedSortedArray s = new SearchinRotatedSortedArray();
		int[] nums = { 4, 5, 6, 7, 1, 2, 3 };
		int target = 2;
		System.out.println(s.search(nums, target));
	}

}
