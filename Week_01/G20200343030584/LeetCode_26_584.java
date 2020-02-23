/**
 * 26.删除排序数组中的重复项
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 */
public class RemoveDuplicate {
    public static void test() {
        //        int[] nums = {0, 1, 1, 1, 3, 3, 3, 6, 6, 7}; // [0,1,3,6,7]
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        new RemoveDuplicate().removeDuplicates3(nums);
        int result = new RemoveDuplicate().removeDuplicates3(nums);
        System.out.println(" result:" + result);
        Utils.printArray(nums);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // 暴力法，两层for循环，每次碰到一个相等的数，就将之覆盖
        int moved = 0;
        int length = nums.length;
        for (int i = 0; i < length - moved - 1; i++) {
            int j = i + 1;
            if (nums[i] == nums[j]) {
                System.arraycopy(nums, j, nums, i, length - j - moved);
                moved++;
                --i;
            }
        }
        System.out.println("moved:" + moved);
        return length - moved;
    }

    public int removeDuplicates2(int[] nums) {
        if (nums.length <= 1) return nums.length;
        // 双指针法
        int p = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[p]) {
                p++;
                nums[p] = nums[i];
            }
        }
        return p + 1;
    }

    public int removeDuplicates3(int[] nums) {
        // 双指针法
        int p = nums.length > 0 ? 1 : 0;
        for (int num : nums) {
            if (num > nums[p - 1]) {
                nums[p++] = num;
            }
        }
        return p;
    }
}
