package com.youzi.leetcode;
//给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
//
// 示例 1: 
//
// 输入: [1,2,3,4,5,6,7] 和 k = 3
//输出: [5,6,7,1,2,3,4]
//解释:
//向右旋转 1 步: [7,1,2,3,4,5,6]
//向右旋转 2 步: [6,7,1,2,3,4,5]
//向右旋转 3 步: [5,6,7,1,2,3,4]
// 
//
// 示例 2: 
//
// 输入: [-1,-100,3,99] 和 k = 2
//输出: [3,99,-1,-100]
//解释: 
//向右旋转 1 步: [99,-1,-100,3]
//向右旋转 2 步: [3,99,-1,-100] 
//
// 说明: 
//
// 
// 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。 
// 要求使用空间复杂度为 O(1) 的 原地 算法。 
// 
// Related Topics 数组


//leetcode submit region begin(Prohibit modification and deletion)
public class Rotate {
    public void rotate(int[] nums, int k) {
        if (k < 1 || nums.length <= 1 || k % nums.length == 0) {
            return;
        }
        // 1.将数组整个倒置
        reverse(nums, 0, nums.length - 1);
        // 2.将前k个元素倒置
        reverse(nums, 0, (k - 1) % nums.length);
        // 3.将后面的元素倒置
        reverse(nums, k % nums.length, nums.length - 1);
    }

    /**
     * 倒置
     */
    private void reverse (int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    /// 环状替换
//    public void rotate(int[] nums, int k) {
//        if (k < 1 || nums.length <= 1 || k % nums.length == 0) {
//            // 数组将不发生改变，直接返回
//            return;
//        }
//
//        // k有可能大于数组长度，等价于对长度取余
//        k = k % nums.length;
//        // 记录遍历元素的个数
//        int count = 0;
//        // 当遍历完所有元素时，结束
//        for (int start = 0; count < nums.length; start++) {
//            int current = start;
//            int previous = nums[start];
//
//            // 一个数组中可能存在多个环，只要start==current了，就结束一个环
//            do {
//                int next = (current + k) % nums.length;
//                int temp = nums[next];
//                nums[next] = previous;
//                previous = temp;
//                current = next;
//                // 遍历的元素个数
//                count++;
//            } while (start != current);
//        }
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
