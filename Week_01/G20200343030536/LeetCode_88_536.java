import java.util.Arrays;

/**
 * @author : Hyuk
 * @description : LeetCode_88_536
 * @date : 2020/2/15 7:29 下午
 */
public class LeetCode_88_536 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, n);
        }

        int i1 = m - 1;
        int i2 = n - 1;
        int i = nums1.length - 1;

        while (i1 >= 0 && i2 >= 0) {
            if (nums1[i1] > nums2[i2]) {
                nums1[i] = nums1[i1];
                i1--;
            } else {
                nums1[i] = nums2[i2];
                i2--;
            }
            i--;
        }

        System.arraycopy(nums2, 0, nums1, 0, i2 + 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        new LeetCode_88_536().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
