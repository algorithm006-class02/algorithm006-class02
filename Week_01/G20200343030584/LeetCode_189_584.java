/**
 * 189.旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。如：
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * https://leetcode-cn.com/problems/rotate-array/
 */
public class RotateArray {
    public static void test() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 4;
        new RotateArray().rotate3(nums, k);
    }

    /**
     * 对指定数组的指定范围进行旋转
     *
     * @param nums 目标数组
     * @param start 起始位置
     * @param end 终点位置
     */
    private static void rotate(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        for (int i = start, j = end; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

    public void rotate(int[] nums, int k) {
        // 暴力法，2层for循环
        // 外层循环控制次数：k次
        // 内层循环负责移动元素，从后往前，每次所有元素向后移动一位，最后一个元素成为第一个元素
        for (int i = 0; i < k; i++) {
            int lastIndex = nums.length - 1;
            int lastValue = nums[lastIndex];
            for (int j = lastIndex; j > 0; j--) {
                nums[j] = nums[j - 1];
            }
            nums[0] = lastValue;
        }
    }

    public void rotate2(int nums[], int k) {
        // 使用额外的辅助数组
        // 将数据的后k个元素按原顺序复制到新数组中
        // 一层for循环，将源数组的前length-k个元素右移k个位置，再把辅助数组中的元素覆盖源数组的前k个元素
        k = k % nums.length;
        if (nums.length <= 1 || k == 0) {
            return;
        }
        int[] extra = new int[k];
        int count = nums.length - k;
        System.arraycopy(nums, count, extra, 0, k);
        for (int i = count - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }
        System.arraycopy(extra, 0, nums, 0, extra.length);
    }

    public void rotate3(int nums[], int k) {
        // 三次旋转法
        // 1.先将整个数组旋转一次，2.旋转前k个元素，3.旋转后length-k个元素
        int length = nums.length;
        k = k % length;
        if (length <= 1 || k == 0) {
            return;
        }
        rotate(nums, 0, length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, length - 1);
    }
}
