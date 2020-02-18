/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 旋转数组
 */

// @lc code=start
class Solution {
    //暴力算法
    //每次都移动1步 就是把末尾的挪到最前面 把最前面再往后一步的逐步往后挪 轮到倒数第二位 循环结束
    // 这么一次遍历只是进行了一次旋转
    //然后再跟进来的k的大小 再进行 k次循环 也就 达到了旋转k的逻辑实现效果
    public void rotate(int[] nums, int k) {
        int temp, previous;
        int length = nums.length;
        for (int i = 0; i < k; i++) {
            previous = nums[length - 1];
            for (int j = 0; j < length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    //空间换时间
    //用一个额外的数组 通过取余数改变位置来达到旋转的效果
    //再遍历一遍去把旋转好的 去放入原数组中  时间复杂度是O(n) 空间复杂度是O(n)
    public void rotateMethod2(int[] nums, int k) {
        int size = nums.length;
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[(i + k) % size] = nums[i];
        }

        for (int i = 0; i < size; i++) {
            nums[i] = a[i];
        }
    }

    //  1 2 3 4 5 先整体反转
    //->5 4 3 2 1 
    //因为k==3
    //前k个数再先去反转
    //  3 4 5 2 1
    //后n - k个数再去反转 以达到旋转k次的最终效果
    //  3 4 5 1 2 时间复杂的是O(n) 其实只是反转了3次
    // 空间复杂度是O(1)
    public void rotateMethod3(int[] nums, int k) {
        int size = nums.length;
        k %= size;
        reverse(nums, 0, size - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, size - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
// @lc code=end

