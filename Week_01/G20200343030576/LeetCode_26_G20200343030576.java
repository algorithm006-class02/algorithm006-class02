package Week_01.G20200343030576;

public class LeetCode_26_G20200343030576 {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                if (i - j > 1) {
                    nums[j + 1] = nums[i];
                    j++;
                }
            }
        }
        return j+1;
    }
}
