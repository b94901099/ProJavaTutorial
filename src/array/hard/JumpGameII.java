package array.hard;

public class JumpGameII {
	public int jump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int lastReach = 0;
		int maxReach = 0;
		int step = 0;
		for (int i = 0; i <= maxReach && i < nums.length; i++) {
			if (i > lastReach) {
				step++;
				lastReach = maxReach;
			}
			maxReach = Math.max(maxReach, nums[i] + i);
		}
		if (maxReach < nums.length - 1) {
			return 0;
		}
		return step;
	}
}
