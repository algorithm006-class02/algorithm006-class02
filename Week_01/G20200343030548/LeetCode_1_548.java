import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //解法1：暴力解法
        // int n = 0;
        // for(int i = 0; i < nums.length - 1; i++){
        //     n = target - nums[i];
        //     for(int j = i +1; j < nums.length;j++){
        //         if(n == nums[j]){
        //             int[] result = new int[]{i,j};
        //             return result;
        //         }
        //     }
        // }
        // return null;
        //解法2：利用哈希算法
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                int[] result = new int[]{map.get(nums[i]),i};
                return result;
            }
            map.put(target-nums[i], i);
        }  
        return null;  
    }
}
// @lc code=end

