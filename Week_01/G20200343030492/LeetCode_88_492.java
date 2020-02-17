package Week_01.G20200343030492;

/**
 * LeetCode_99_492
 */
public class LeetCode_88_492 {

	/**
	 * 整体思路：先把nums1的所有元素往后移动n位，空出前n个位置，然后逐个比较两个数组的大小，补上nums1前面空出的地方。时间复杂度：O(n + 2m)，空间复杂度：O(1)
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
        for (int i = m - 1; i >= 0; i--) {
            nums1[i + n] = nums1[i];
        }
        int i = n, j = 0, idx = 0;
        while (i < m + n && j < n) {
            if (nums1[i] < nums2[j]) {
                nums1[idx++] = nums1[i++];
            } else {
                nums1[idx++] = nums2[j++];
            }
        }
        if (i < m + n) {
            System.arraycopy(nums1, i, nums1, idx, m + n - i);
        }
        if (j < n) {
            System.arraycopy(nums2, j, nums1, idx, n - j);
        }
	}
	
	/**
	 * 整体思路：从后往前插入，对比nums1和nums2的元素，比较大的放在nums1的后面。时间复杂度：O(n + m)，空间复杂度：O(1)
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2, 0, nums1, 0, j + 1);
    }
}