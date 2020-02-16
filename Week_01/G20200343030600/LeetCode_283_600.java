/**
 283.移动零
    遍历nums，判断每位是否为0，若不是则往前移动并将该位置零，前移的index为非零元素最大下标;
    对于数组前面一直为非零元素的情况，只需增加index即可，不作前移和置零操作。
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                if(i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}