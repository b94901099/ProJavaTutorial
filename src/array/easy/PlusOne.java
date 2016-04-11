package array.easy;

public class PlusOne {

	public int[] plusOne(int[] digits) {
		if (digits == null || digits.length == 0) {
			return digits;
		}

		int plus = 1;
		for (int i = digits.length - 1; i >= 0; i--) {
			int sum = digits[i] + plus;
			System.out.println("sum = " + sum);
			if (sum > 9) {
				digits[i] = sum % 10;
				plus = sum / 10;
			} else {
				digits[i] = sum;
				plus = 0;
			}
			System.out.println("digits[" + i + "] = " + digits[i]);
			System.out.println("plus = " + plus);
		}

		if (plus > 0) {
			int[] newDigits = new int[digits.length + 1];
			newDigits[0] = plus;
			for (int i = 0; i < digits.length; i++) {
				newDigits[i + 1] = digits[i];
			}
			return newDigits;
		}
		return digits;

	}

	public static void main(String[] args) {
		int[][] numSet = { { 9, 9 }, { 0 }, { 1, 8 } };

		PlusOne po = new PlusOne();

		for (int i = 0; i < numSet.length; i++) {
			int[] sum = po.plusOne(numSet[i]);
			for (int j = 0; j < sum.length; j++) {
				System.out.print(sum[j] + " ");
			}
			System.out.println();
		}

	}

}
