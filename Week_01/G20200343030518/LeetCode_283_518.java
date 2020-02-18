class Solution {
    public void moveZeroes(int[] nums) { // space o(1), time : o(2n) = o(n)
        if (nums == null || nums.length < 1) {
            return;
        }
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast ++) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow ++;
            }
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow ++;
        }
    }
}