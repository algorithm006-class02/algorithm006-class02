package Week_01.G20200343030492;
import java.util.*;
/**
 * LeetCode_1_492
 */
public class LeetCode_1_492 {

	/**
	 * 整体思路：枚举法，时间复杂度：O(n ^ 2)，空间复杂度：O(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }
        return res;
	}
	
	/**
	 * 使用哈希表，保存遍历过的值及下标。时间复杂度近似：O(n)，空间复杂度：O(n)
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum1(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}