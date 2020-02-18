public class LeetCode_88_378 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (null == nums1 || null == nums2)
            return;

        int l = m + n - 1;
        int l1 = m - 1;
        int l2 = n - 1;
        while (l1 >= 0 && l2 >= 0) {
            if (nums1[l1] > nums2[l2]) {
                nums1[l] = nums1[l1];
                l1--;
            } else {
                nums1[l] = nums2[l2];
                l2--;
            }
            l--;
        }
        while (l2 >= 0) {
            nums1[l] = nums2[l2];
            l--;
            l2--;
        }
    }
}
