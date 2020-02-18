package algorithm.leetCode.geek.No1;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ltw
 * on 2020-02-14.
 */
public class Solution {
    //solution1: 时间复杂度 O(n)  空间复杂度O(n)
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp) && map.get(tmp) != i) { //目标元素不能是 循环数本身
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
        }
        return result;
    }

    //solution2:  时间复杂度O(n2) 空间复杂度O(1)
//    class Solution {
//        public int[] twoSum(int[] nums, int target) {
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i + 1; j < nums.length; j++) {
//                    if (nums[j] == target - nums[i]) {
//                        return new int[] { i, j };
//                    }
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {2, 7, 11, 15};
        int target = 9;
        for (int x : solution.twoSum(test, target)) {
            System.out.println(x);
        }
    }
}
