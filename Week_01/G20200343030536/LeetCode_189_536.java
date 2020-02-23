/**
 * @author : Hyuk
 * @description : _LeetCode_189_536
 * @date : 2020/2/15 6:06 下午
 */
public class LeetCode_189_536 {

    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int len = nums.length;
        traverse(nums, 0, len - 1);
        traverse(nums, 0, k - 1);
        traverse(nums, k, len - 1);
    }

    private void traverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
