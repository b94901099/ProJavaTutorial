package array.medium;

public class SortColors {
	public void sortColors(int[] nums) {
		int left = 0, right = nums.length - 1;
		while (left < nums.length && nums[left] == 0)
			left++;
		while (right >= 0 && nums[right] == 2)
			right--;
		for (int i = left; i <= right; i++) {
			switch (nums[i]) {
			case 0:
				swap(nums, i, left);
				left++;
				break;
			case 2:
				swap(nums, i, right);
				right--;
				i--;
				break;
			}
		}
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	public static void main(String[] args) {
		SortColors o = new SortColors();
		int[] nums = { 1, 0 };
		o.sortColors(nums);
		for (int i : nums)
			System.out.print(i + ",");
	}
}
