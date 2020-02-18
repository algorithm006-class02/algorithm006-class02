package com.sebar.algorithm;

/**
 * @author liguang@youxin.com
 * @Date 2020/2/12
 * @Description 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，
 * 同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class Leetcode_283_566 {
    /**
     * 移动zero 解决方案一
     *
     * @param nums 需要移动的数组
     * @return
     */
    public int[] solutionOne(int[] nums) {
        //先完成将0放到后面的操作
        for (int i = 0; i < nums.length - 1; i++) {
            // 从此位置开始判断，是不是0，不是0，不需要下一步
            if (nums[i] != 0) {
                continue;
            } else {
                // 这个位置是0，则需要同下一位不是0的进行位置对换
                int changePosition = i + 1;
                Boolean flag = false;
                for (int j = i + 1; j >= i && j < nums.length; j++) {
                    if (nums[j] == 0) {
                        continue;
                    } else {
                        // 位置对换
                        changePosition = j;
                        flag = true;
                        break;
                    }
                }
                if (flag) {
                    // 进行元素对换
                    int temp = nums[i];
                    nums[i] = nums[changePosition];
                    nums[changePosition] = temp;
                }
            }

        }
        return nums;
    }

    /**
     * 移动zero,解决方案二
     * 思路：循环该数组，记录有多少个0，将非0元素与第一个0，进行位置对换
     *
     * @param nums
     * @return
     */
    public int[] solutionTwo(int[] nums) {
        int lastNotZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果是0，记录0的数量，并更当前位置进行交换
            if (nums[i] != 0) {
                nums[lastNotZeroIndex++] = nums[i];
            }
        }
        // 将后续位置全部补0
        for (int j = lastNotZeroIndex; j < nums.length; j++) {
            nums[j] = 0;
        }
        return nums;
    }

    /**
     * 快慢指针，
     * 第一个指针一直指针0元素
     * 第二个指针向前遍历，如果出现非0 的元素，两个交换位置
     * 劣势：内存消耗大， 交换次数过多，可优化减少交换次数
     * @param nums
     * @return
     */
    public int[] solutionThree(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        int j = 0;

        for (int i = 0; i < nums.length; i++) {
            //当前元素不等于0的时候与左边的进行
            if (nums[i] != 0) {
                // 交换位置
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
        return nums;
    }


    public static void main(String[] args) {
        Leetcode_283_566 zeros = new Leetcode_283_566();
        int[] ints = zeros.solutionTwo(new int[]{1, 2, 0, 3, 0});
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]);
        }
    }
}
