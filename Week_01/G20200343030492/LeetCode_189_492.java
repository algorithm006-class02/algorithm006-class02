package Week_01.G20200343030492;

/**
 * LeetCode_189_492
 */
public class LeetCode_189_492 {

	/**
	 * 整体思路：循环k轮，每轮每个数向右移动一位。时间复杂度：O(N)，空间复杂度：O(1)
	 */
	public void rotate(int[] nums, int k) {
        int tmp,previous;
        for (int i = 0 ; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                tmp = nums[j];
                nums[j] = previous;
                previous = tmp;
            }
        }
	}
	
	/**
	 * 整体思路：环状代替。比如下标i的数字放在下标j的位置上，其中j = (i + k) mod nums.length，原来下标j的数字放在下标q的位置上，其中q = (j + k) mod nums.length，以此类推。
	 * 		    当循环回到原来的位置而数组还有未移动的数字时，此时往前移动一位再重复上述操作，直到数组中所有数字都进行了移位。时间复杂度：O(N)，空间复杂度：O(1)。
	 */
	public void rotate1(int[] nums, int k) {
        int count = 0;
        k = k % nums.length;
        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int previous = nums[start];
            do {
				int next = (current + k) % nums.length;
                int tmp = nums[next];
                nums[next] = previous;
                previous = tmp;
                current = next;
                count++;
            } while (start !=  current );
        }
	}

	/**
	 * 反转法，假如nums=[1,2,3,4,5,6,7],k=3，则过程如下图所示：
	 * 1. [7,6,5,4,3,2,1] // reverse(nums, 0, nums.length - 1)
	 * 2. [5,6,7,4,3,2,1] // reverse(nums, 0, k - 1)
	 * 3. [5,6,7,1,2,3,4] // reverse(nums, k, nums.length - 1)
	 * 时间复杂度：O(N)，空间复杂度：O(1)
	 */
	public void rotate3(int[] nums, int k) {
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
	}

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}