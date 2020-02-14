import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * <p>
 * 说明:
 * <p>
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 * <p>
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 * 输出: [1,2,2,3,5,6]
 * <p>
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 */
public class MergeSortedArray {
    public static void test() {
        int[] nums1 = {1, 5, 0, 0, 0};
        int[] nums2 = {2, 5, 8};
        MergeSortedArray mergeSortedArray = new MergeSortedArray();
//        mergeSortedArray.merge(nums1, 4, nums2, 3);
        mergeSortedArray.merge2(nums1, 2, nums2, 3);

        Utils.printArray(nums1);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 暴力，合并后再排序
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 双指针，从前往后
        // 新增一个额外数组，用来排序，再把此数据复制到num1
        int[] extra = new int[m + n];
        int i = 0, j = 0;
        for (int index = 0; i < m && j < n; index++) {
            if (nums1[i] < nums2[j]) {
                extra[index] = nums1[i++];
            } else {
                extra[index] = nums2[j++];
            }
        }
        // 处理没有遍历到的数据
        if (i < m) {
            System.arraycopy(nums1, i, extra, n + i, m - i);
        } else if (j < n) {
            System.arraycopy(nums2, j, extra, m + j, n - j);
        }
        System.arraycopy(extra, 0, nums1, 0, extra.length);
    }


    public void merge3(int[] nums1, int m, int[] nums2, int n) {
        // 双指针，从后往前
        // 循环对比时，较大的数放后面，因为两个数组都是排好序的，这样循环一次下来数字就是排好序的了
        int i = m - 1;
        int j = n - 1;
        for (int index = m + n - 1; i >= 0 && j >= 0; index--) {
            if (nums1[i] < nums2[j]) {
                nums1[index] = nums2[j--];
            } else {
                nums1[index] = nums1[i--];
            }
        }
        // 这里只有num2没有遍历完这一种可能
        if (j >= 0) {
//            System.out.print("出现没有遍历完的情景 " + j);
            System.arraycopy(nums2, 0, nums1, 0, j + 1); // 注意是j+1
        }
    }
}
