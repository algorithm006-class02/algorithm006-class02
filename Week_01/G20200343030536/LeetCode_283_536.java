/**
 * @author : Hyuk
 * @description : LeetCode_283_536
 * @date : 2020/2/15 10:56 上午
 */
public class LeetCode_283_536 {

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0, len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for (int i = index; i < len; ++i) {
            nums[i] = 0;
        }
    }

    public void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int index = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] != 0) {
                nums[index] = nums[i];
                if (index != i) {
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}
