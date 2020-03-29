package G20200343030448;

import java.util.Arrays;

public class LeetCode_493_448 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;
        int mid = left + (right - left) / 2;
        int count = mergeSort(nums, left, mid) + mergeSort(nums, mid+1, right);
        for (int i = left, j = mid + 1; i <= mid; i++) {
            while(j <= right && nums[i]>(long)nums[j]*2) j++;
            count += j - (mid + 1);
        }
        Arrays.sort(nums, left, right + 1);
        return count;
    }
}
