class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int k = 0; k < nums.length - 1; k++) {
            if (nums[k] != nums[k + 1]) {
                nums[++i] = nums[k + 1];
            }
        }
        return i + 1;
    }
}