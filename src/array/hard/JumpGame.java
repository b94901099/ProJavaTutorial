package array.hard;

public class JumpGame {

	public boolean canJump(int[] nums) {
		if (nums == null || nums.length == 0)
			return true;
		int range = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (range == 0)
				return false;
			range = Math.max(range - 1, nums[i]);
		}
		return true;
	}

	public static void main(String[] args) {

	}

}
