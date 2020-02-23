//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表


import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 暴力双层循环嵌套解决思路
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return new int[2];
        // 利用 双层 HashSet 解决，通过空间换时间来解决，别的数据结构来辅助解决问题
//        Map<Integer, Integer> hashMap = new HashMap<>();
//
//        for (int i = 0; i < nums.length; i++) {
//            hashMap.put(nums[i], i);
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            int compare = target - nums[i];
//            if (hashMap.containsKey(compare) && hashMap.get(compare) != i) {
//                return new int[]{i, hashMap.get(compare)};
//            }
//        }
//        return new int[2];

        // 利用 一遍 HashSet 解决，通过空间换时间来解决，别的数据结构来辅助解决问题
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compare = target - nums[i];
            if (map.containsKey(compare)) {
                return new int[]{map.get(compare), i};
            }
            map.put(nums[i], i);
        }
        return new int[2];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
