/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class DeleteDuplicates {

    public int removeDuplicates(int[] nums) {
        //去重
        int count = 1;
        int i=0,j=nums.length;
        while (i<j){
            if (i+1<j&&nums[i]!=nums[i+1]){
                nums[count++] = nums[i+1];
            }
            i++;
        }
        return count;
    }
}
