package Week_01.G20200343030492;

/**
 * LeetCode_26_492
 */
public class LeetCode_26_492 {

	/**
	 * 整体思路：双指针法，一个指针用于遍历，一个指针表示下一个非重复元素要保存的位置。时间复杂度：O(N)，空间复杂度：O(1)
	 */
	public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
	}

	/**
	 * 整体思路：一个指针，从左往右遍历，遍历过程中记下总的重复的值的个数duplicates，当遇到非重复的值就根据duplicates计算这个值要保存到哪个下标。时间复杂度：O(N)，空间复杂度：O(1)
	 */
	public int removeDuplicates1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int duplicates = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                duplicates++;
            } else {
                nums[i - duplicates] = nums[i];
            }
        }
        return nums.length - duplicates;
    }
	


	
}