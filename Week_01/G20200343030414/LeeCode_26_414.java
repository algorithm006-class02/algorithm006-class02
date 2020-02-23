package Week_01.G20200343030414;

/**
 * @author Xinshuai
 * @description 题目链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
 * @since 2020-02-15 22:20
 */
public class LeeCode_26_414 {

    /**
     * 1、直接遍历
     */
    public int removeDuplicates1(int[] nums) {
        if (nums.length < 2) return nums.length;
        int offset = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[offset]) {
                offset ++;
                nums[offset] = nums[i];
            }
        }
        return offset + 1;
    }

    /**
     * 2、双指针
     */
    public int removeDuplicates2(int[] nums) {
        if (nums.length < 2) return nums.length;
        int offset = 0, i = 1;
        while (i < nums.length) {
            if (nums[offset] != nums[i]) {
                offset ++;
                nums[offset] = nums[i];
            }
            i ++;
        }
        return offset + 1;
    }

}
