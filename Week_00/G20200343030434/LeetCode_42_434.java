package algorithm.leetCode.geek.No42;

/**
 * @author ltw
 * on 2020-02-15.
 */
class Solution {

    //https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
    //need review
    //solution1: 无法 AC 但结果是对的 时间复杂度: O(n*m) 空间复杂度 O(1) 按行比较
    public int trap(int[] height) {
        int max = findMax(height);
        int result = 0;
        for (int i = 0; i < max; i++) {
            result += containsZero(height);
            decrease1(height);
        }
        return result;
    }

    private void decrease1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[i] = nums[i] - 1;
            }
        }
    }

    private int findMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }

    private int containsZero(int[] nums) { //计算除前后数组中间有多少个0
        int max = -1; // 标记最大最小有数字的index
        int min = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (min < 0 && max < 0) {
                    min = i;
                    max = i;
                    continue;
                } else {
                    max = i;
                }
            }

        }
        int numbers = 0;
        for (int i = min; i <= max; i++) {
            if (nums[i] == 0) {
                numbers++;
            }
        }
        return numbers;
    }

    //soulution2 :  时间复杂度 O(n2) 空间复杂度 O(1)  按列比较
//    public int trap(int[] height) {
//        int sum = 0;
//        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
//        for (int i = 1; i < height.length - 1; i++) {
//            int max_left = 0;
//            //找出左边最高
//            for (int j = i - 1; j >= 0; j--) {
//                if (height[j] > max_left) {
//                    max_left = height[j];
//                }
//            }
//            int max_right = 0;
//            //找出右边最高
//            for (int j = i + 1; j < height.length; j++) {
//                if (height[j] > max_right) {
//                    max_right = height[j];
//                }
//            }
//            //找出两端较小的
//            int min = Math.min(max_left, max_right);
//            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
//            if (min > height[i]) {
//                sum = sum + (min - height[i]);
//            }
//        }
//        return sum;
//    }

    //solution3 双指针
    //solution4 dp
    //solution5 stack
    //有待补充

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {4,2,0,3,2,5};
        System.out.println(solution.trap(test));
    }
}