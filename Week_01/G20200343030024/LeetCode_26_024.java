class Solution {
    public int removeDuplicates(int[] nums) {
         int newLength = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[newLength] != nums[i]) {
                nums[++newLength] = nums[i];
            }
        }

        return newLength + 1;
    }
}