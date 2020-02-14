/**
 * @author:
 * @Date: 2020-02-14 11:19
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */
public class LeetCode_26_490 {

    public int removeDuplicates(int[] nums) {
        int count = 0;
        for(int i = 1 ;i < nums.length ; i++) {
            if(nums[i] != nums[count]) {
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }
}
