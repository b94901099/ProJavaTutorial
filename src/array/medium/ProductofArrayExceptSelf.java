package array.medium;

public class ProductofArrayExceptSelf {

	/**
	 * output[i] = product of numbers at the left of i X product of number at
	 * the right of i <br>
	 * which means product before i X product after i
	 * 
	 * @param nums
	 * @return
	 */
	public int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] beforeProduct = new int[n];
		int[] afterProduct = new int[n];
		int[] output = new int[n];

		beforeProduct[0] = 1;
		for (int i = 1; i < n; i++) {
			beforeProduct[i] = nums[i - 1] * beforeProduct[i - 1];
		}

		for (int i = 0; i < beforeProduct.length; i++)
			System.out.print(beforeProduct[i] + ",");
		System.out.println();

		afterProduct[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			afterProduct[i] = nums[i + 1] * afterProduct[i + 1];
		}

		for (int i = 0; i < afterProduct.length; i++)
			System.out.print(afterProduct[i] + ",");
		System.out.println();

		for (int i = 0; i < n; i++) {
			output[i] = beforeProduct[i] * afterProduct[i];
		}

		return output;
	}

	public static void main(String[] args) {
		ProductofArrayExceptSelf p = new ProductofArrayExceptSelf();
		int[] nums = { 9, 0, -2 };
		int[] output = p.productExceptSelf(nums);
		for (int i = 0; i < output.length; i++) {
			System.out.print(output[i] + ",");
		}
	}

}
