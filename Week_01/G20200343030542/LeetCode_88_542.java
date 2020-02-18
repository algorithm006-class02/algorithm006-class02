public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mergedIndex = m + n - 1;
        int left = m - 1;
        int right = n - 1;
        while (left >= 0 && right >= 0) {
            if (nums1[left] >= nums2[right]) {
                nums1[mergedIndex] = nums1[left];
                left--;
                mergedIndex--;
            } else {
                nums1[mergedIndex] = nums2[right];
                right--;
                mergedIndex--;
            }
        }
        while (left >= 0) {
            nums1[mergedIndex] = nums1[left];
            left--;
            mergedIndex--;
        }
        while (right >= 0) {
            nums1[mergedIndex] = nums2[right];
            right--;
            mergedIndex--;
        }

    }
}