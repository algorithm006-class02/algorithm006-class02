package algorithm.leetCode.geek.No283;

/**
 * @author ltw
 * on 2020-02-12.
 */
class Solution {
    //solution1: 时间复杂度：O(n)  空间复杂度O(1)
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {0, 0, 1};
        solution.moveZeroes(test);
    }
}
