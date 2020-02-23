class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int totalLastIndex = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i > -1 && j > -1) {
            if (nums1[i] > nums2[j]) {
                nums1[totalLastIndex] = nums1[i];
                i--;
            } else {
                nums1[totalLastIndex] = nums2[j];
                j--;
            }
            totalLastIndex--;
        }
        if (j >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, j + 1);
        }
    }
}