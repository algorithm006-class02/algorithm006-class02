public class LeetCode_26_378 {
    public int removeDuplicates(int[] nums) {
        int pre = nums.length == 0 ? 0 : 1;
        for(int i = 0; i < nums.length;i++){
            if(nums[pre - 1 ] != nums[i]){
                nums[pre] = nums[i];
                pre++;
            }
        }
        return pre;
    }
}
