package array.hard;

public class MedianOfTwoSortedArrays {

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int i = 0, j = 0;
		int[] merge = new int[m + n];

		while (i < m && j < n) {
			if (nums1[i] <= nums2[j]) {
				merge[i + j] = nums1[i++];
			} else {
				merge[i + j] = nums2[j++];
			}
		}

		while (i < m)
			merge[i + j] = nums1[i++];
		while (j < n)
			merge[i + j] = nums2[j++];

		int med = (m + n) / 2;
		if ((m + n) % 2 == 0) {
			return (double) (merge[med] + merge[med - 1]) / 2;
		}
		return (double) merge[med];
	}

	public static void main(String[] args) {
		MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();
		int[] nums1 = { 1, 2, 3 };
		int[] nums2 = { };
		System.out.println(m.findMedianSortedArrays(nums1, nums2));
	}

}
