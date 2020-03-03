package G20200343030448;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_1_448 {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        Map<Integer, Integer> hm = new HashMap<Integer, Integer>(len);
        for (int i = 0; i < len; i++) {
            Integer key = hm.get(target - nums[i]);
            if (key != null) {
                return new int[]{key, i};
            }
            hm.put(nums[i], i);
        }
        throw new IllegalArgumentException();
    }
}
