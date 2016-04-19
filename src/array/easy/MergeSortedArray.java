package array.easy;

public class MergeSortedArray {
	public void merge(int nums1[], int m, int nums2[], int n) {
		if (nums1 == null || nums2 == null || nums1.length < 1 || nums2.length < 1) {
			return;
		}

		int indexPos = m + n - 1;
		int index1 = m - 1;
		int index2 = n - 1;
		while (index1 >= 0 && index2 >= 0) {
			if (nums1[index1] >= nums2[index2]) {
				nums1[indexPos--] = nums1[index1--];
			} else {
				nums1[indexPos--] = nums2[index2--];
			}
		}
		while (index1 >= 0) {
			nums1[indexPos--] = nums1[index1--];
		}
		while (index2 >= 0) {
			nums1[indexPos--] = nums2[index2--];
		}
	}
}
