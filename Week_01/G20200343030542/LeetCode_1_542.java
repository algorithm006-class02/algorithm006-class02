
import java.util.HashMap;
import java.util.Map;
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[0];
        }
        Map<Integer, Integer> itemIndexCache = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
            int searchTarget = target - nums[i];
            Integer index = itemIndexCache.get(searchTarget);
            if (index != null) {
                return new int[]{index, 1};
            } else {
                itemIndexCache.put(nums[i], i);
            }
        }
        return new int[0];
    }
}