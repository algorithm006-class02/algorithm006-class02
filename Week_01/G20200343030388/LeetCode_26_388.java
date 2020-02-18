
public class LeetCode_26_388 {

    /**
     * 思路：双指针，即快慢指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        int len = nums.length;

        //只有一个元素或没有元素，则直接返回
        if (len < 2) {
            return len;
        }

        int j = 0;

        for (int i = 1; i < len; i++) {

            if (nums[i] != nums[i - 1]) {
                nums[++j] = nums[i];
            }
        }

        return ++j;

    }
}
