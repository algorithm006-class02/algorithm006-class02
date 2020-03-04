class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (right - left > 1) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[left] && nums[mid] > nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return Math.min(nums[left], nums[right]);
    }
}
