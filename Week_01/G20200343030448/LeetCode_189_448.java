package G20200343030448;

public class LeetCode_189_448 {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if (len == 1) {
            return;
        }
        k = k % len;
        for (int i = 0; i < len / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
        for (int i = 0; i < k / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[k - i - 1];
            nums[k - i - 1] = temp;
        }
        for (int i = 0; i < (len - k) / 2; i++) {
            int temp = nums[k + i];
            nums[k + i] = nums[len - i - 1];
            nums[len - i - 1] = temp;
        }
    }
}
