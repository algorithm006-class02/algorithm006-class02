package Week_01.G20200343030492;

/**
 * LeetCode_66_492
 */
public class LeetCode_66_492 {

	/**
	 * 递归的思想，如果最后一位加一后溢出，则递归调用前一位加一。时间复杂度：O(n)，空间复杂度：O(1)
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int[] digits) {
        plus1(digits, digits.length - 1);
        if (digits[0] == 0) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            return res;
        } else {
            return digits;
        }
    }

    public void plus1(int[] digits, int idx) {
        if (idx >= 0) {
            digits[idx] += 1;
            if (digits[idx] >= 10) {
                digits[idx] = 0;
                plus1(digits, idx - 1);
            }
        }
    }
}