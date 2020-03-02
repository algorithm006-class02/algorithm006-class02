class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];

        int left = 0; int right = nums.length - 1;
        while(left < right){
            int mid = left + ((right - left) >> 1);
            
            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1 ;
            }
        }

        return nums[right];
    }
}