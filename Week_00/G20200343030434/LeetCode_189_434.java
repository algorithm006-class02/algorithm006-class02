package algorithm.leetCode.geek.No189;

/**
 * @author ltw
 * on 2020-02-14.
 */
class Solution {
    //solution1: 时间复杂度 O(n*k) 空间复杂度 O(1)
    public void rotate(int[] nums, int k) {
        for (int i = 0; i < k; i++) {
            rotateArray(nums);
        }
    }

    private void rotateArray(int[] nums) {
        int x = nums[nums.length - 1];
        for (int i = nums.length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = x;
    }

    //solution2: 时间复杂度 O(n) 空间复杂度O(1)
//    public void rotate(int[] nums, int k) {
//        k %= nums.length;
//        reverse(nums, 0, nums.length - 1);
//        reverse(nums, 0, k - 1);
//        reverse(nums, k, nums.length - 1);
//    }
//
//    public void reverse(int[] nums, int start, int end) { //反转数组
//        while (start < end) {
//            int temp = nums[start];
//            nums[start] = nums[end];
//            nums[end] = temp;
//            start++;
//            end--;
//        }
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(test, k);
        for (int x : test) {
            System.out.println(x);
        }
    }
}
