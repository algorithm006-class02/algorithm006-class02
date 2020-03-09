package G20200343030448;

public class LeetCode_55_448 {
    public boolean canJump(int[] nums) {
        int len = nums.length - 1;
        int goodPosition = len;
        for (int i = len; i >= 0; i--) {
            if (nums[i] + i >= goodPosition) {
                goodPosition = i;
            }
        }
        return goodPosition == 0;
    }
}
