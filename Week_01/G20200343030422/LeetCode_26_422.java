public class LeetCode_26_422 {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int result = 1;
        int curNum = nums[0];
        for(int i=1; i<nums.length; i++){
            if(nums[i] != curNum){
                nums[result++] = nums[i];
                curNum = nums[i];
            }
        }
        return result;
    }
}