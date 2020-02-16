package Week_01.G20200343030414;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/rotate-array/
 * @since 2020-02-16 20:21
 */
public class LeetCode_189_414 {

    /**
     * 1、通过双层for循环解决（时间复杂度高，耗时严重）
     */
    public void rotate1(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        for (int i = 0; i < k; i ++) {
            int temp =  nums[n - 1];
            for (int j = n - 1; j > 0; j --) {
                nums[j] = nums[j - 1];
            }
            nums[0] = temp;
        }
    }

    /**
     * 2、通过数学求余的方式解决（不过空间复杂度是O(n)）
     */
    public void rotate2(int[] nums, int k) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    /**
     * 3、最巧妙的反转做法
     * <p>
     *     首先将所有元素反转，然后反转前 k 个元素，再反转后面 n-k 个元素即可
     */
    public void rotate3(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
         while (start < end) {
             int temp = nums[start];
             nums[start ++] = nums[end];
             nums[end --] = temp;
         }
    }

}
