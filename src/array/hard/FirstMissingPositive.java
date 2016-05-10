package array.hard;

public class FirstMissingPositive {

	public static void main(String[] args) {
		FirstMissingPositive o = new FirstMissingPositive();
		int[] nums = { 2, 2 };
		System.out.println(o.firstMissingPositive(nums));
	}

	public int firstMissingPositive(int[] nums) {
		int minPositive = Integer.MAX_VALUE;
		int countPositive = 0;
		for (int i = 0; i < nums.length; i++) {
			int cmp = Integer.MAX_VALUE;
			if (nums[i] > 0) {
				cmp = nums[i];
				minPositive = Math.min(minPositive, cmp);
				swap(nums, i, countPositive++);
			}
		}

		if (countPositive == 0)
			return 1;

		for (int i = 0; i < countPositive; i++) {
			if (nums[i] == i + minPositive)
				continue;
			int index = nums[i] - minPositive;
			if (index < 0 || index == countPositive)
				continue;
			swap(nums, i, index);
		}

		for (int i = 0; i < countPositive; i++) {
			if (nums[i] != i + minPositive) {
				if (nums[i] == minPositive && minPositive > 1)
					return minPositive - 1;
				return i + minPositive;
			}
		}

		if (minPositive > 1)
			return minPositive - 1;
		return countPositive + minPositive;

	}

	void swap(int[] nums, int i, int j) {
		if (i < 0 || j < 0 || i >= nums.length || j >= nums.length)
			return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
