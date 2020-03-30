/*
 * @lc app=leetcode.cn id=493 lang=java
 *
 * [493] 翻转对
 */

// @lc code=start
class Solution {
    int[] helper;

    public int reversePairs(int[] nums) {
        this.helper = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = start + (end - start) / 2;
        int cnt = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i] / 2.0 > nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        myMerge(nums, start, mid, end);
        return cnt;
    }

    private void myMerge(int[] nums, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            helper[i] = nums[i];
        }
        int p1 = start;
        int p2 = mid + 1;
        int i = start;
        while (p1 <= mid || p2 <= end) {
            if (p1 > mid || (p2 <= end && helper[p1] >= helper[p2])) {
                nums[i++] = helper[p2++];
            } else {
                nums[i++] = helper[p1++];
            }
        }
    }
}
// @lc code=end

