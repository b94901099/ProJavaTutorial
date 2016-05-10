package array.hard;

public class FindTheDuplicateNumber {
	public int findDuplicate(int[] nums) {
		int start = 0, end = nums.length - 1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			int countSmallerThanTarget = 0;
			int countEqualToTarget = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == mid) {
					countEqualToTarget++;
					if (countEqualToTarget == 2)
						return mid;
				} else if (nums[i] < mid) {
					countSmallerThanTarget++;
				}
			}

			if ((countSmallerThanTarget + countEqualToTarget) > mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return start;
	}
}
