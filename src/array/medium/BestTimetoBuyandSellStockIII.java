package array.medium;

public class BestTimetoBuyandSellStockIII {

	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) {
			return 0;
		}

		int n = prices.length;
		int[] maxProfitBeforeDay = new int[n];
		int[] maxProfitAfterDay = new int[n];

		int min = prices[0];
		maxProfitBeforeDay[0] = 0;
		for (int i = 1; i < n; i++) {
			maxProfitBeforeDay[i] = Math.max(maxProfitBeforeDay[i - 1],
					prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		int max = prices[n - 1];
		maxProfitAfterDay[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--) {
			maxProfitAfterDay[i] = Math.max(maxProfitAfterDay[i + 1], max
					- prices[i]);
			max = Math.max(max, prices[i]);
		}

		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			maxProfit = Math.max(maxProfit, maxProfitBeforeDay[i]
					+ maxProfitAfterDay[i]);
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		BestTimetoBuyandSellStockIII o = new BestTimetoBuyandSellStockIII();
		int[] prices = { 2, 1, 3, 4, 0, 5 };
		System.out.println(o.maxProfit(prices));
	}

}
