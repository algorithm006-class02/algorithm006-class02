/**
 * 283.移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * <p>
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 * <p>
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 */
public class MoveZeros {
    public static void test() {
        int[] nums = {0, 1, 0, 3, 12};
//        int[] nums = {0, 1};
        new MoveZeros().moveZeroes4(nums);
        Utils.printArray(nums);
    }

    public void moveZeroes(int[] nums) {
        // 暴力法 两层循环，每次以类似冒泡的方式将0挪到最后
        int zeros = 0;
        for (int i = 0; i < nums.length - zeros; ) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - 1 - zeros; j++) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
                ++zeros;
            }
            // 小细节：当两个0相邻时，i不能自增
            if (nums[i] != 0) {
                i++;
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        // 标记法，遇到0标记一次->i++，遇到非0，则将之向前移动i个位置
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else if (zeros > 0) {
                // 小细节
                nums[i - zeros] = nums[i];
                nums[i] = 0;
            }
        }
    }

    public void moveZeroes3(int[] nums) {
        // 双指针法
        // i负责遍历所有数据，j负责指向第一个0的位置，遇到非0，交换i、j位置元素
        if (nums.length <= 1) {
            return;
        }
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j++] = temp;
            }
        }
    }

    public void moveZeroes4(int[] nums) {
        // 双指针法 + 两次循环
        // i负责遍历所有数据，j负责记录所有非0数量
        // 最后将数组后j个元素置0
        int zeros = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[zeros++] = nums[i];
            }
        }

        for (int i = zeros; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
