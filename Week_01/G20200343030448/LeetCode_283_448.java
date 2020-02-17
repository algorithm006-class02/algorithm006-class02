package G20200343030448;

public class LeetCode_283_448 {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int slowPointer = 0;
        for (int fastPointer = 0; fastPointer < len; fastPointer++) {
            if (nums[fastPointer] != 0) {
                nums[slowPointer] = nums[fastPointer];
                slowPointer++;
            }
        }
        for (int i = slowPointer; i < len; i++) {
            nums[i] = 0;
        }
    }
}
