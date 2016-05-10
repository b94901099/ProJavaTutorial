package dp.medium;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];

		int n = nums.length;

		int[] maxMoneyFirstHouseRobbed = new int[n];
		maxMoneyFirstHouseRobbed[0] = nums[0];
		maxMoneyFirstHouseRobbed[1] = nums[0];

		for (int i = 2; i < n - 1; i++) {
			maxMoneyFirstHouseRobbed[i] = Math.max(
					maxMoneyFirstHouseRobbed[i - 1],
					maxMoneyFirstHouseRobbed[i - 2] + nums[i]);
		}
		maxMoneyFirstHouseRobbed[n - 1] = maxMoneyFirstHouseRobbed[n - 2];

		int[] maxMoneyFirstHouseNotRobbed = new int[n];
		maxMoneyFirstHouseNotRobbed[0] = 0;
		maxMoneyFirstHouseNotRobbed[1] = nums[1];

		for (int i = 2; i < n; i++) {
			maxMoneyFirstHouseNotRobbed[i] = Math.max(
					maxMoneyFirstHouseNotRobbed[i - 1],
					maxMoneyFirstHouseNotRobbed[i - 2] + nums[i]);
		}

		int maxMoney = Math.max(maxMoneyFirstHouseRobbed[n - 1],
				maxMoneyFirstHouseNotRobbed[n - 1]);
		return maxMoney;
	}

	public static void main(String[] args) {
		HouseRobberII o = new HouseRobberII();
		int[] nums = { 1, 3, 1 };
		System.out.println(o.rob(nums));
	}
}
