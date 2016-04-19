package array.easy;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			if (map.containsKey(nums[i])) 
				count = map.get(nums[i]);
			map.put(nums[i], ++count);
		}
		
		int threshold = nums.length / 2;
		for (int key: map.keySet()) {
			if (map.get(key) > threshold)
				return key;
		}
		return -1;
	}
}
