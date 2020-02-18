/**
 *
 * 1.两数之和（简单）
 * a + b = target
 *
 * 思路（精简）：
 * 1.暴力法 （目前先写这一种）
 *  时间复杂度 O(n^2)
 *
 * 2.两遍哈希表
 *
 * 3.一遍哈希表
 *
 *
 */
public class Leetcode_1_390 {

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


}
