package array.medium;

public class ContainerWithMostWater {

	public int maxArea(int[] height) {
		int lp = 0;
		int rp = height.length - 1;
		int maxArea = Integer.MIN_VALUE;

		while (lp < rp) {
			int area = Math.min(height[lp], height[rp]) * (rp - lp);
			maxArea = Math.max(maxArea, area);
			if (height[lp] < height[rp]) {
				lp++;
			} else {
				rp--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {

	}

}
