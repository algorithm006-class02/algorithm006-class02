public class LeetCode_153_590 {

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;

        // case1.
        if (nums[right] > nums[0]) {
            return nums[0];
        }

        while (right >= left) {
            int mid = left + (right - left) / 2;

            // case2.
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // case3.
            if (nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }

            // case4.
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
