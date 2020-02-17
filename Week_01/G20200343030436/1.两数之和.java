import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    //暴力求解法
    //空间复杂度O(n*n)
    public int[] twoSum(int[] nums, int target) {
        int[] a = new int[2];
        int numsize = nums.length;
        for (int i = 0; i < numsize - 1; i++) {
            for (int j = i + 1; j < numsize; j++) {
                if (nums[i] + nums[j] == target) {
                    a[0] = i;
                    a[1] = j;
                    return a;
                }
            }
        }
        return new int[0];
    }

    // 空间换时间 时间复杂度O(n) 空间复杂度 O(n)
    public int[] twoSumMethod2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {
                return new int[]{map.get(b),i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException(("No two sum solution"));
    }
}
// @lc code=end

