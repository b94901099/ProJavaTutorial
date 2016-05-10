package array.medium;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();

		Integer n1 = null, n2 = null;
		int c1 = 0, c2 = 0;

		for (int i : nums) {
			if (n1 != null && i == n1.intValue()) {
				c1++;
			} else if (n2 != null && i == n2.intValue()) {
				c2++;
			} else if (c1 == 0) {
				c1 = 1;
				n1 = i;
			} else if (c2 == 0) {
				c2 = 1;
				n2 = i;
			} else {
				c1--;
				c2--;
			}
			System.out
					.println(String
							.format("candidate1 = %d, count1 = %d, candidate2 = %d, count2 = %d",
									n1, c1, n2, c2));
		}

		c1 = c2 = 0;

		for (int i : nums) {
			if (i == n1.intValue()) {
				c1++;
			} else if (i == n2.intValue()) {
				c2++;
			}
		}

		if (c1 > nums.length / 3)
			result.add(n1);
		if (c2 > nums.length / 3)
			result.add(n2);
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		MajorityElementII m = new MajorityElementII();
		int[] nums = { 3, 3, 3, 3, 1, 1, 2, 2, 1, 2, 1, 1, 2, 2 };
		int[] nums1 = { 1, 2, 2, 3, 2, 1, 1, 3 };
		m.majorityElement(nums1);
	}
}
