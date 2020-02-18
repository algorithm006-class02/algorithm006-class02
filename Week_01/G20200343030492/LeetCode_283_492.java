package Week_01.G20200343030492;

public class LeetCode_283_492 {
	/**
	 * 整体思路：把非零的移动到数组前面，最后在数组后面补上0。时间复杂度：O(N)，空间复杂度：O(1)
	 */
    public void moveZeroes(int[] nums) {
		int idx = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				nums[idx++] = nums[i];
			}
		}
		for (int i = idx; i < nums.length; i++) {
			nums[i] = 0;
		}
	}
	
	/**
	 * 整体思路：老师课堂上说的双指针交换法。时间复杂度：O(N)，空间复杂度：O(1)
	 */
	public void moveZeroes1(int[] nums) {
		int j = 0;
		for (int i = 0;i < nums.length; i++) {
			if (nums[i] != 0) {
				int tmp = nums[i];
				nums[i] = nums[j];
				nums[j++] = tmp;
			}
		}
	}
}