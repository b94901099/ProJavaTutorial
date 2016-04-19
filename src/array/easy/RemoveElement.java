package array.easy;

public class RemoveElement {

	public int removeElement(int[] nums, int val) {
		if (nums == null || nums.length == 0)
			return 0;

		int size = nums.length;
		int head = 0, tail = nums.length - 1;
		while (head <= tail) {
			if (head == tail && nums[head] == val) {
				nums[head] = 0;
				size--;
			} else if (nums[tail] == val) {
				tail--;
				size--;
			} else if (nums[head] == val) {
				swap(nums, head, tail);
				head++;
				tail--;
				size--;
			} else {
				head++;
			}
		}
		return size;
	}

	private void swap(int[] nums, int head, int tail) {
		int tmp = nums[head];
		nums[head] = nums[tail];
		nums[tail] = tmp;
	}

	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(r.removeElement(nums, 2));
		for (int i : nums)
			System.out.print(i + ", ");
	}
}
