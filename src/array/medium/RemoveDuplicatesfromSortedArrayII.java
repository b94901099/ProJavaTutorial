package array.medium;

public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int start = 0;
        int end = start + 1;
        int count = 0;

        while (start < nums.length - 1 && end < nums.length) {
            if (nums[start] == nums[end]) {
                if (count == 0) {
                    nums[++start] = nums[end];
                    end++;
                    count++;
                } else {
                    end++;
                }
            } else {
                count = 0;
                nums[++start] = nums[end];
                end++;
            }
        }
        return start + 1;
    }

	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII o = new RemoveDuplicatesfromSortedArrayII();
		int[] nums = { 3, 3, 3, 4, 5, 6, 6, 6, 6, 7, 7, 8, 9, 9, 9 };
		int length = o.removeDuplicates(nums);
		for (int i = 0; i < length; i++)
			System.out.print(nums[i] + ",");
	}

}
