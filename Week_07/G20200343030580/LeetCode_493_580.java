class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private static int mergeSort(int[] nums, int left, int right) {
        if (right <= left) {
            return 0;
        }
        int mid = (left + right) >> 1;
        int result = mergeSort(nums, left, mid) + mergeSort(nums, mid + 1, right);
        for (int i = left, j = mid + 1; i < mid + 1; i++) {
            while (j <= right && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            result += j - (mid + 1);
        }
        merge(nums, left, mid, right);
        return result;
    }

    private static void merge(int[] nums, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left, j = mid + 1, index = 0;
        while (i <= mid && j <= right) {
            tmp[index++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        if (i <= mid + 1) {
            System.arraycopy(nums, i, tmp, index, mid - i + 1);
        }
        if (j <= right) {
            System.arraycopy(nums, j, tmp, index, right - j + 1);
        }
        System.arraycopy(tmp, 0, nums, left, tmp.length);
    }
}
