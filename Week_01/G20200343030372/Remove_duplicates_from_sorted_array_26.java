package G20200343030372;

/**
 * @author Chen.C
 * @date 2020/2/12
 */
public class Remove_duplicates_from_sorted_array_26 {

    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}
