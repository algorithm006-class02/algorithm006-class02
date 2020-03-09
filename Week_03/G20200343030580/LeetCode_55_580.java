class Solution {
    public boolean canJump(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            int j = i - 1;
            while (j >= 0 && i - j > nums[j]) {
                j--;
            }
            if (j < 0) {
                return false;
            } else {
                i = j;
            }
        }
        return i == 0;
    }
}