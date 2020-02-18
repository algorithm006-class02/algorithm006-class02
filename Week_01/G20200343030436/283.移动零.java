/*
 * @lc app=leetcode.cn id=283 lang=java
 *
 * [283] 移动零
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        int length = nums.length;
        for (int i = 0 ; i < length; ++i) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (i != index) {
                    nums[i] = 0;
                }
                index++;
            }
            // [1 2 3 0 5 0 9 0 29]
            // 1 当循环到是0的时候 没去做赋值 接着去进入下面的循环
            // 等下面的循环的时候，这次索引的数组的值不是0的时候 把这个非0值赋值到刚才 0的数组位置上
            //                  把0的值 赋值到这次循环的 非0位置上
            // 在把这个index的++
        }

        //1.遍历数组把非零元素（假设有k个）按顺序存入数组的0至k-1位置上；
        //2.把原数组剩余未新赋值部分(k到n-1位置上)全设置为0；
        // int index = 0;
        // int length = nums.length;
        // for(int i = 0; i< length; i++) {
        //     if (nums[i] != 0) {
        //         nums[index] = nums[i];
        //         index++;
        //     }
        // }

        // for(;index < length; index++) {
        //     nums[index] = 0;
        // }
    }

    public void moveZeroesMethod2(int[] nums) {
        if (nums == null) {
            return;
        }
        //第一次遍历的时候，j指针记录非0的个数，只要是非0的就赋值给nums[j]
        int j = 0;
        for (int i = 0; i< nums.length; ++i) {
            if (nums[i] != 0) {
                nums[j++] = nums[i];
            }
        }
        //非0的直接完全赋值完
        //第二次遍历的时候，剩下的都是补0
        for (int i = j; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
// @lc code=end

