package array.medium;

public class SearchforaRange {
	public int[] searchRange(int[] nums, int target) {
		int[] result = { -1, -1 };
		if (nums == null || nums.length == 0)
			return result;

		int start = 0, end = nums.length - 1;
		boolean found = false;

		// find left bound
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				found = true;
				end = mid - 1;
			} else if (nums[mid] < target)
				start = mid + 1;
			else
				end = mid - 1;
		}

		if (nums[start] == target) {
			found = true;
			result[0] = start;
		} else if (nums[end] == target) {
			found = true;
			result[0] = end;
		} else if (!found) {
			return result;
		} else
			result[0] = end + 1;

		// find right bound
		start = 0;
		end = nums.length - 1;
		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] > target)
				end = mid - 1;
			else
				start = mid + 1;
		}

		if (nums[end] == target)
			result[1] = end;
		else if (nums[start] == target)
			result[1] = start;
		else
			result[1] = start - 1;

		return result;
	}

	public static void main(String[] args) {
		SearchforaRange o = new SearchforaRange();
		int[] nums = { 0, 0, 1, 2, 3, 3, 4 };
		int target = 2;
		int[] result = o.searchRange(nums, target);
		for (int i : result)
			System.out.print(i + ",");
	}
}
