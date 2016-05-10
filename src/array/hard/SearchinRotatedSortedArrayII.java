package array.hard;

public class SearchinRotatedSortedArrayII {
	public boolean search(int[] nums, int target) {
		for (int num : nums)
			if (num == target)
				return true;
		return false;
	}
}
