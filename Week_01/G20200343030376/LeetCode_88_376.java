/**
 *  Week 01  LeetCode 88
 * 
 *  88.合并两个有序的数组
 * 
 *  指针的方式需要在研究一下
 * 
 */
public void merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    Arrays.sort(nums1);
  }