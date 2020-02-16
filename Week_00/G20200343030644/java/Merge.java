import java.util.Arrays;

/**
 *  https://leetcode-cn.com/problems/merge-sorted-array/
 */
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int res[] = new int[m+n];
        int i =0,j=0,count=0;
        while (i+j<n+m){
            if(j>=n) {
                res[count] = nums1[i++];
            }else if(i>=m) {
                res[count] = nums2[j++];
            }else if(nums1[i]>nums2[j]){
                res[count] = nums2[j++];
            }else if(nums1[i]<nums2[j]){
                res[count] = nums1[i++];
            }else {
                res[count] = nums2[j++];
            }
            count++;
        }
        nums1 = res;
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n){
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }
}
