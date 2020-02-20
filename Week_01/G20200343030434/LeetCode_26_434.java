package algorithm.leetCode.geek.No26;

class Solution {
    //solution1: 时间复杂度 O(n) 空间复杂度 O(1)
    public int removeDuplicates(int[] nums) {
        int j = 1; //
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
            } else {
                nums[j] = nums[i];
                j++;
            }
        }
        return j; //返回最后一个下标+1
    }

    //solution2:
//    public int removeDuplicates(int[] nums) {
//        if (nums.length == 0) return 0;
//        int j = 0;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] != nums[j]) {
//                j++;
//                nums[j] = nums[i];
//            }
//        }
//        return j + 1;
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] test = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(solution.removeDuplicates(test));

    }
}
