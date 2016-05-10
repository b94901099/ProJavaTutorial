package array.medium;

public class BestTimetoBuyandSellStockII {

	public int maxProfit(int[] prices) {

		if (prices == null || prices.length < 2)
			return 0;

		int base = prices[0], profit = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > base) {
				profit += prices[i] - base;
			}
			base = prices[i];
		}
		return profit;
	}

	public static void main(String[] args) {

	}

}
