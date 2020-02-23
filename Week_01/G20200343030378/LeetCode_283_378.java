public class LeetCode_283_378 {
    public void moveZeroes(int[] nums) {
        int pre = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                swap(nums,pre,i);
                pre++;
            }
        }
    }

    private void swap(int[] nums,int l1,int l2){
        int tmp = nums[l1];
        nums[l1] = nums[l2];
        nums[l2] = tmp;
    }
}
