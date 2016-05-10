package array.medium;

public class MaximumProductSubarray {

	public int maxProduct(int[] nums) {
		int maxTemp = nums[0];
		int minTemp = nums[0];
		int maxProduct = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int a = maxTemp * nums[i];
			int b = minTemp * nums[i];
			maxTemp = Math.max(Math.max(a, b), nums[i]);
			minTemp = Math.min(Math.min(a, b), nums[i]);
			maxProduct = Math.max(maxProduct, maxTemp);
			System.out.println(String.format(
					"i=%d , maxTemp = %d , minTemp = %d , maxProduct = %d", i,
					maxTemp, minTemp, maxProduct));
		}
		return maxProduct;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 9, 0, -2, 4, -3 };
		MaximumProductSubarray m = new MaximumProductSubarray();
		System.out.println(m.maxProduct(nums));
	}

}
