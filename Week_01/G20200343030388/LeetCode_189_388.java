
public class LeetCode_189_388 {

    /**
     * 使用三次反转法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {

        int len = nums.length;

        k %= len;

        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int k, int i) {

        while (k < i){
            int tmp = nums[k];
            nums[k] = nums[i];
            nums[i] = tmp;

            k ++;
            i --;
        }
    }
}
