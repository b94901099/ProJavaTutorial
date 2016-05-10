package array.medium;

public class RemoveDuplicatesfromSortedArray {
	public int removeDuplicates(int[] nums) {
		if (nums == null)
			return 0;
		if (nums.length < 2)
			return nums.length;
		int start = 0, end = 1;
		while (start < nums.length - 1 && end < nums.length) {
			if (nums[start] != nums[end]) {
				nums[++start] = nums[end];
				end++;
			} else {
				end++;
			}
		}

		return start + 1;
	}

}
