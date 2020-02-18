import java.util.Arrays;

/**
 * @author : Hyuk
 * @description : LeetCode_26_536
 * @date : 2020/2/15 3:49 下午
 */
public class LeetCode_26_536 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int pre = 0;
        for (int i = 1, len = nums.length; i < len; ++i) {
            if (nums[i] != nums[pre]) {
                nums[++pre] = nums[i];
            }
        }
        return pre + 1;
    }
}
