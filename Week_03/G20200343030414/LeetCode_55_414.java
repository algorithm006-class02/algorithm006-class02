package Week_03.G20200343030414;

/**
 * @author Xinshuai
 * @description
 * @since 2020-03-01 17:40
 */
public class LeetCode_55_414 {

    /**
     * 从后开始的贪心算法
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        int endReachable = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + i >= endReachable) {
                endReachable = i;
            }
        }
        return endReachable == 0;
    }

}
