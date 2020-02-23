class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        //记录非o元素开始位置
        int k = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        while(k < nums.length) {
            nums[k] = 0;
            k++;
        }
    }
}
