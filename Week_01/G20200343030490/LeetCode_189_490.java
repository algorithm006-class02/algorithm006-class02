/**
 * @author:
 * @Date: 2020-02-14 18:02
 * @Copyright: 2019 www.lenovo.com Inc. All rights reserved.
 */

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

public class LeetCode_189_490 {
    /**
     * 思路分析，无论nums的长度为 奇偶 无论 k为奇偶，依次向后交换，技术条件 exchange 次数 == nums.length.
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int count = 0;
        for(int start = 0 ; count < nums.length ; start++) {
            int currentIndex =  start;
            int current = nums[currentIndex];
            do{
                int nextIndex = (currentIndex + k) % nums.length;
                int next = nums[nextIndex];

                nums[nextIndex] = current;
                current = next;
                currentIndex = nextIndex;
                count++;
            }while(currentIndex != start);
        }
    }

   /*
   // 固定方法将数组向后移动k位 空间复杂度 O(1),时间复杂度O(n)
    public void rotate(int[] nums, int k) {
             if(k == 0) return;
             k = k % nums.length;
             reverse(nums,0,nums.length-1);
             reverse(nums,0,k-1);
             reverse(nums,k,nums.length-1);
         }

        private void reverse(int[] nums,int start,int end) {
            while(start < end) {
                int temp =  nums[start];
                nums[start++] = nums[end];
                nums[end--] = temp;
            }
        }
   */
}
