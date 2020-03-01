/**
 * 153. 寻找旋转排序数组中的最小值（二分法）
 */

class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}
