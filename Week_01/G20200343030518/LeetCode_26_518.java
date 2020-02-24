class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int total = 1;
        for (int i = 1; i < nums.length; i ++) {
            if(nums[i] != nums[i -1]){
                nums[total ++] = nums[i]; //  not only return nums but also need to remove dupicate
            }
        }
        return total;
    }
}