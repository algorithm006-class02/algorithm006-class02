class Solution {
    int[] nums;
    int target;

    public int find_rotation_index(int left, int right) {
        if (nums[left] < nums[right]) return 0;
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] > nums[pivot + 1]) return pivot + 1;
            else {
                if (nums[pivot] < nums[left]) right = pivot - 1;
                else left = pivot + 1;
            }
        }
        return 0;
    }

    public int search(int left, int right) {
        while (left <= right) {
            int pivot = (left + right) / 2;
            if (nums[pivot] == target) return pivot;
            else {
                if (target < nums[pivot]) right = pivot - 1;
                else left = pivot + 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return this.nums[0] == target ? 0 : -1;
        int rotation_index = find_rotation_index(0, n - 1);
        if (nums[rotation_index] == target) return rotation_index;
        if (rotation_index == 0) return search(0, n - 1);
        if (target < nums[0]) return search(rotation_index, n - 1);
        return search(0, rotation_index);
    }
}


class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            //前半部分有序,使用小于等于
            if (nums[start] <= nums[mid]) {
                //target 在前半部分
                if (target >= nums[start] && target < nums[mid]) end = mid - 1;
                else start = mid + 1;
            } else {
                if (target <= nums[end] && target > nums[mid]) start = mid + 1;
                else end = mid - 1;
            }
        }
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;
            //后半部分有序
            if (nums[mid] < nums[end]) {
                if (nums[mid] < target && target <= nums[end]) start = mid + 1;
                else end = mid - 1;
            } else {
                if (nums[mid] > target && target >= nums[start]) end = mid - 1;
                else start = mid + 1;
            }
        }
        return -1;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if ((nums[0] > target) ^ (nums[0] > nums[mid]) ^ (target > nums[mid]))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo == hi && nums[lo] == target ? lo : -1;
    }
}