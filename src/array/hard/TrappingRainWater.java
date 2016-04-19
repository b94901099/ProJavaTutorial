package array.hard;

public class TrappingRainWater {

	public int trap(int[] height) {
		int sum = 0;
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		for (int i = 1; i < leftMax.length; i++) {
			int max = Math.max(leftMax[i - 1], height[i - 1]);
			leftMax[i] = max;
		}
		for (int i = rightMax.length - 2; i >= 0; i--) {
			int max = Math.max(rightMax[i + 1], height[i + 1]);
			rightMax[i] = max;
		}

		for (int i = 1; i < height.length - 1; i++) {
			int h = Math.min(leftMax[i], rightMax[i]);
			if (h > height[i])
				sum += h - height[i];
		}

		return sum;
	}

	public static void main(String[] args) {
		TrappingRainWater t = new TrappingRainWater();
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(t.trap(height));
	}

}
