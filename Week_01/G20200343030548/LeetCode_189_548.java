/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0){
            return;
        }
        k = k % nums.length;
        int pre = 0, tmp = 0, j = 0, index = 0;
        for (int i = 0; i < k; i++){
            index = i;
            pre = nums[i];
            do{
                index = (index + k) % nums.length;
                tmp = nums[index];
                nums[index] = pre;
                pre = tmp;
                j++;
            }while(index != i);
            if(j == nums.length){
                break;
            }
            
        }
    }
}
// @lc code=end

