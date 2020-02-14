import java.util.HashMap;
import java.util.Map;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i,j;
        if(nums.length==0){
            return 0;
        }
        for(i=0,j=1;j<nums.length;j++)
            if(nums[i]!=nums[j])
                nums[++i]=nums[j];
        return i+1;
    }
}