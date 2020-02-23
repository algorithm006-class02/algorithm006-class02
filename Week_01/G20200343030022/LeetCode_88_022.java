import java.util.Arrays;
/**
 * 题目：合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。

 说明:
 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 示例:

 输入:
 nums1 = [1,2,3,0,0,0], m = 3
 nums2 = [2,5,6],       n = 3

 输出: [1,2,2,3,5,6]
 */
class LeetCode_88_022 {


    /**
     * 直接将nums2 copy到nums1，当然也可以直接用System.arraycopy(nums2,0,nums1,n,n);
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i = 0;i < nums2.length;i++){
            nums1[i+m] = nums2[i];
        }
        Arrays.sort(nums1);
    }

    /**
     * 开辟一个数组，分别用两个指针进行比较放入新数组中区时间复杂度为O(n)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int p1 = 0;
        int p2 = 0;

        int p = 0;
        while(p1 < m && p2 < n){
            nums1[p++] = (nums1_copy[p1] < nums2[p2] ? nums1_copy[p1++] : nums2[p2++]);
        }
        if(p1 < m){
            System.arraycopy(nums1_copy,p1,nums1,p1+p2,m+n-p1-p2);
        }
        if(p2 < n){
            System.arraycopy(nums2,p2,nums1,p1+p2,m+n-p1-p2);
        }
    }
}