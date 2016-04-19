package array.easy;

public class MoveZeroes {

	public void moveZeroes(int[] nums) {

		if (nums == null || nums.length <= 1)
			return;
		int n = nums.length;
		int endOfNonZero = -1;

		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				endOfNonZero = i;
				break;
			}
		}

		if (endOfNonZero == -1)
			return;

		int p = endOfNonZero + 1;
		while (p < n) {
			while (p < n && nums[p] == 0)
				p++;
			if (p == n)
				break;
			swap(nums, endOfNonZero, p);
			endOfNonZero++;
			p++;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		MoveZeroes m = new MoveZeroes();
		int[] nums = { 0, 1, 0, 3, 12 };
		m.moveZeroes(nums);
		for (int num : nums)
			System.out.print(num + ",");
	}

}
