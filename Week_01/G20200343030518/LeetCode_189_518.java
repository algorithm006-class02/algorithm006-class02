class Solution {
        public void rotate(int[] nums, int k) { // space o(1), time o(n)
            k %= nums.length; // need consider once k == nums.length or k > nums.length
            if(k != 0) {  // 0 means need to move 0 steps
                reverse(nums, 0, nums.length - 1);
                reverse(nums, 0, k - 1);
                reverse(nums, k, nums.length - 1);
            }
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