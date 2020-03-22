/**
 * @author : Hyuk
 * @description : LeetCode_152_536
 * @date : 2020/3/14 7:51 下午
 */
public class LeetCode_152_536 {

    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) { return 0; }
        int min = nums[0], max = nums[0], res = nums[0];
        int preMin = nums[0], preMax = nums[0];
        for (int i = 1, len = nums.length; i < len; ++i) {
            max = Math.max(nums[i], Math.max(preMax * nums[i], preMin * nums[i]));
            min = Math.min(nums[i], Math.min(preMax * nums[i], preMin * nums[i]));
            res = Math.max(res, max);
            preMax = max;
            preMin = min;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -3, -2};
        System.out.println(new LeetCode_152_536().maxProduct(nums));
    }
}
